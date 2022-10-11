package site.metacoding.humancloud.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.metacoding.humancloud.domain.subscribe.Subscribe;
import site.metacoding.humancloud.service.SubscribeService;
import site.metacoding.humancloud.web.dto.CMRespDto;

@RequiredArgsConstructor
@Controller
public class SubscribeController {

    private final SubscribeService subscribeService;

    @GetMapping("/test/{userId}")
    public String test(@PathVariable Integer userId, Model model){
        model.addAttribute("subscribe", subscribeService.구독기업보기(userId));
        return "page/subscribe";
    }

    @PostMapping("/subscribe")
    public @ResponseBody CMRespDto<?> subscribeCompany(@RequestBody Subscribe subscribe){
        subscribeService.구독하기(subscribe);
        return new CMRespDto<>(1, "ok", null);
    }
}
