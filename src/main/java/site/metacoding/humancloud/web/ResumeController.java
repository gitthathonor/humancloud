package site.metacoding.humancloud.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.service.ResumeService;
import site.metacoding.humancloud.web.dto.CMRespDto;
import site.metacoding.humancloud.web.dto.request.resume.SaveDto;

@RequiredArgsConstructor
@Controller
public class ResumeController {

  private final ResumeService resumeService;

  @GetMapping("resume/detail/{resumeId}")
  public String detailResume(@PathVariable Integer resumeId, Integer userId, Model model){
    model.addAttribute("resume", resumeService.이력서상세보기(resumeId, userId).get("resume"));
    model.addAttribute("category", resumeService.이력서상세보기(resumeId, userId).get("category"));
    return "resume/detail";
  }

  @GetMapping("/resume/saveForm")
  public String saveResumeForm() {
    return "resume/saveForm";
  }

  @PostMapping(value = "/resume/save", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
  public @ResponseBody CMRespDto<?> create(@RequestPart("file") MultipartFile file, 
      @RequestPart("imgDto") SaveDto saveDto) throws Exception {
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
    saveDto.setResumePhoto(imgName);
  
    resumeService.이력서저장(saveDto);
    return new CMRespDto<>(1, "업로드 성공", imgName);
  }


}
