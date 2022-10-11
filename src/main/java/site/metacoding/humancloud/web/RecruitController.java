package site.metacoding.humancloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.service.ApplyService;

@RequiredArgsConstructor
@Controller
public class RecruitController {

  @GetMapping("/kkk")
  public String kkk() {
    return "page/recruit/detail";
  }
}
