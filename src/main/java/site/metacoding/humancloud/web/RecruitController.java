package site.metacoding.humancloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.service.ApplyService;
import site.metacoding.humancloud.service.RecruitService;
import site.metacoding.humancloud.web.dto.CMRespDto;

@RequiredArgsConstructor
@Controller
public class RecruitController {

  private final RecruitService recruitService;

  @GetMapping("/recruit/list")
  public String viewList(Model model) {
    model.addAttribute("recruits", recruitService.채용공고목록보기());
    return "page/recruit/recruitList";
  }

  @PostMapping("/recruit/category")
  public @ResponseBody CMRespDto<?> viewCategory(@RequestBody Category category) {
    return new CMRespDto<>(1, "OK", recruitService.분류별채용공고목록보기(category.getCategoryName()));
  }

  @GetMapping("/recruit/order")
  public @ResponseBody CMRespDto<?> orderList(@RequestParam("order") String order) {
    return new CMRespDto<>(1, "ok", recruitService.정렬하기(order));
  }
}
