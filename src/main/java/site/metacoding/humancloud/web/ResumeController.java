package site.metacoding.humancloud.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.service.ResumeService;
import site.metacoding.humancloud.service.UserService;
import site.metacoding.humancloud.web.dto.CMRespDto;
import site.metacoding.humancloud.web.dto.request.resume.SaveDto;
import site.metacoding.humancloud.web.dto.request.resume.UpdateDto;

@RequiredArgsConstructor
@Controller
public class ResumeController {

  private final ResumeService resumeService;
  private final UserService userService;


  @DeleteMapping("/resume/deleteById/{resumeId}")
  public @ResponseBody CMRespDto<?> deleteResume(@PathVariable Integer resumeId) {
    resumeService.이력서삭제(resumeId);
    return new CMRespDto<>(1, "이력서 삭제 성공", null);
  }

  @PutMapping(value = "resume/update/{resumeId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
      MediaType.MULTIPART_FORM_DATA_VALUE })
  public @ResponseBody CMRespDto<?> updateResume(@PathVariable Integer resumeId,
      @RequestPart("file") MultipartFile file,
      @RequestPart("updateDto") UpdateDto updateDto) throws Exception {

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
    updateDto.setResumePhoto(imgName);

    resumeService.이력서수정(resumeId, updateDto);

    return new CMRespDto<>(1, "이력서 수정 성공", null);
  }

  @GetMapping("resume/updateForm/{resumeId}")
  public String updateResumeForm(@PathVariable Integer resumeId, Integer userId, Model model) {
    model.addAttribute("resume", resumeService.이력서상세보기(resumeId, userId).get("resume"));
    model.addAttribute("category", resumeService.이력서상세보기(resumeId, userId).get("category"));
    model.addAttribute("user", resumeService.이력서상세보기(resumeId, userId).get("user"));
    return "page/resume/updateForm";
  }

  @GetMapping("resume/detail/{resumeId}")
  public String detailResume(@PathVariable Integer resumeId, Integer userId, Model model) {
    model.addAttribute("resume", resumeService.이력서상세보기(resumeId, userId).get("resume"));
    model.addAttribute("category", resumeService.이력서상세보기(resumeId, userId).get("category"));
    model.addAttribute("user", resumeService.이력서상세보기(resumeId, userId).get("user"));
    return "page/resume/detail";
  }

  @GetMapping("/resume/saveForm/{userId}")
  public String saveResumeForm(Integer userId, Model model) {
    model.addAttribute("user", userService.유저정보보기(userId));
    return "page/resume/saveForm";
  }

  @PostMapping(value = "/resume/save", consumes = { MediaType.APPLICATION_JSON_VALUE,
      MediaType.MULTIPART_FORM_DATA_VALUE })
  public @ResponseBody CMRespDto<?> create(@RequestPart("file") MultipartFile file,
      @RequestPart("saveDto") SaveDto saveDto) throws Exception {
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
