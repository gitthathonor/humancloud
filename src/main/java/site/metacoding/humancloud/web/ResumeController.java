package site.metacoding.humancloud.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.resume.Resume;
import site.metacoding.humancloud.service.ResumeService;
import site.metacoding.humancloud.web.dto.CMRespDto;
import site.metacoding.humancloud.web.dto.request.resume.WriteDto;

@RequiredArgsConstructor
@Controller
public class ResumeController {

  private final ResumeService resumeService;

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
