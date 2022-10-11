package site.metacoding.humancloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.service.ApplyService;
import site.metacoding.humancloud.service.RecruitService;

@RequiredArgsConstructor
@Controller
public class RecruitController {

  private final RecruitService recruitService;

  @GetMapping("/recruit/list")
  public String viewList(Model model) {
    model.addAttribute("recruits", recruitService.채용공고목록보기());
    return "page/recruit/recruitList";
  }
}
