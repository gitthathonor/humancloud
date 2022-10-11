package site.metacoding.humancloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.service.RecruitService;
import site.metacoding.humancloud.web.dto.CMRespDto;
import site.metacoding.humancloud.web.dto.request.recruit.SaveDto;

@RequiredArgsConstructor
@Controller
public class RecruitController {

    private final RecruitService recruitService;



    @GetMapping("/write")
    public String writeFrom() {
        return "page/recruit/writeForm";
    }

    @PostMapping("/write")
    public @ResponseBody CMRespDto<?> write(@RequestBody SaveDto saveDto) {

        recruitService.구인공고작성(saveDto);

        return new CMRespDto<>(1, "성공", null);
    }

    @GetMapping("/")
    public String main() {
        return "page/main";
    }
}
