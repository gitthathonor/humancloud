package site.metacoding.humancloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.recruit.Recruit;
import site.metacoding.humancloud.service.RecruitService;
import site.metacoding.humancloud.web.dto.CMRespDto;
import site.metacoding.humancloud.web.dto.request.recruit.SaveDto;

@RequiredArgsConstructor
@Controller
public class RecruitController {

  private final RecruitService recruitService;

  @GetMapping("recruit/update/{id}")
  public String updateFrom(@PathVariable(required = false) Integer id, Model model) {
    Recruit recruitPS = recruitService.공고상세페이지(id);
    model.addAttribute("Recruit", recruitPS);

    return "page/recruit/updateForm";
  }

  @GetMapping("recruit/detail/{id}")
  public String recruit_Detail(@PathVariable Integer id, Model model) {

    Recruit recruitPS = recruitService.공고상세페이지(id);
    model.addAttribute("Recruit", recruitPS);
    return "page/recruit/detail";
  }

  @GetMapping("recruit/save")
  public String writeFrom() {
    return "page/recruit/saveForm";
  }

  @PostMapping("recruit/save")
  public @ResponseBody CMRespDto<?> write(@RequestBody SaveDto saveDto) {

    recruitService.구인공고작성(saveDto);

    return new CMRespDto<>(1, "성공", null);
  }

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