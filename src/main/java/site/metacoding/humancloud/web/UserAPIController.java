package site.metacoding.humancloud.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.service.UserService;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@RequiredArgsConstructor
@Controller
public class UserAPIController {

    private final UserService userService;

    private final HttpSession session;

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
}
