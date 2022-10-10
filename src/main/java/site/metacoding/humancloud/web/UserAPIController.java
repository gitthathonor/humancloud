package site.metacoding.humancloud.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.user.User;
import site.metacoding.humancloud.service.UserService;
import site.metacoding.humancloud.web.dto.CMRespDto;
import site.metacoding.humancloud.web.dto.request.resume.user.JoinDto;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@RequiredArgsConstructor
@Controller
public class UserAPIController {

    private final UserService userService;

    private final HttpSession session;



    @PostMapping("/user/join")
    public @ResponseBody CMRespDto<?> joinUser(@RequestBody JoinDto joinDto){
        userService.회원가입(joinDto);
        return new CMRespDto<>(1, "ok", null);
    }

    @GetMapping("/user/usernameSameCheck")
    public @ResponseBody CMRespDto<?> usernameSameCheck(@RequestParam("username") String username){
        Boolean result = userService.유저네임중복체크(username);
        if(result==true){
            return new CMRespDto<>(1, "ok", true);
        }
        return new CMRespDto<>(1, "same id", false);
    }

    @GetMapping("/user")
    public String userSaveForm(){
        return "page/user/userSaveForm";
    }

    @GetMapping("test/login")
    public String testlogin(Model model){
        // Session userId = (Session) session.getAttribute("principal");
        model.addAttribute("user", userService.유저정보보기(1));
        model.addAttribute("resume", userService.이력서보기(1));
        return "mypageSample";
    }
    @GetMapping({"/", "/main"})
    public String main(){
        return "page/main";
    }
}
