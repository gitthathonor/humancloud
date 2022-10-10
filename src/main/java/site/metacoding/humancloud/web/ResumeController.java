package site.metacoding.humancloud.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.resume.Resume;
import site.metacoding.humancloud.service.ResumeService;
import site.metacoding.humancloud.web.dto.CMRespDto;
import site.metacoding.humancloud.web.dto.request.resume.WriteDto;

@RequiredArgsConstructor
@Controller
public class ResumeController {

  @GetMapping("/test")
  public void test(){
    resumeService.추천순보기(1);
  }

  private final ResumeService resumeService;

//  @GetMapping("/test")
//  public @ResponseBody CMRespDto<?> test(){
//    return new CMRespDto<>(1, "OK", resumeService.추천순보기(1));
//  }
//  @GetMapping("/page")
//  public String testpage(){
//    System.out.println(resumeService.학력순보기());
//    List<Resume> test = resumeService.학력순보기();
//    System.out.println(test.get(0).getResumeTitle());
//    return "resumelist";
//  }

  @GetMapping("/resume")
  public String viewList(Model model){
    model.addAttribute("resumeData", resumeService.이력서목록보기());
    return "page/resume/resumeList";
  }

  @PostMapping("/resume")
  public @ResponseBody CMRespDto<?> viewCategory(@RequestBody Category category){
    return new CMRespDto<>(1, "OK", resumeService.분류별이력서목록보기(category.getCategoryName()));
  }

  @GetMapping("/resume/list")
  public @ResponseBody CMRespDto<?> orderList(@RequestParam("order") String order){
    return new CMRespDto<>(1, "ok", resumeService.정렬하기(order, 1));
  }

  @GetMapping("/resume/saveForm")
  public String saveResumeForm(WriteDto writeDto) {
    return "resume/saveForm";
  }

  @PutMapping(value = "/resume/save", consumes = { MediaType.APPLICATION_JSON_VALUE,
      MediaType.MULTIPART_FORM_DATA_VALUE })
  public @ResponseBody CMRespDto<?> create(@RequestPart("file") MultipartFile file,
      @RequestPart("writeDto") WriteDto writeDto) throws Exception {
    int pos = file.getOriginalFilename().lastIndexOf(".");
    String extension = file.getOriginalFilename().substring(pos + 1);
    String filePath = "C:\\temp\\img\\";
    String imgSaveName = UUID.randomUUID().toString();
    String imgName = imgSaveName + "." + extension;

    File makeFileFolder = new File(filePath);
    if (!makeFileFolder.exists()) {
      if (!makeFileFolder.mkdir()) {
        throw new Exception("File.mkdir():Fail.");
      }
    }

    File dest = new File(filePath, imgName);
    try {
      Files.copy(file.getInputStream(), dest.toPath());
    } catch (IOException e) {
      e.printStackTrace();
    }

    Resume resume = writeDto.toEntity(imgName);
    resumeService.이력서저장(resume);
    return new CMRespDto<>(1, "업로드 성공", imgName);
  }
}
