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
import site.metacoding.humancloud.web.dto.request.resume.user.LoginDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@RequiredArgsConstructor
@Controller
public class UserAPIController {

    private final UserService userService;

    private final HttpSession session;

    @PutMapping("/update/{id}")
    public @ResponseBody CMRespDto<?> update(@PathVariable Integer id, @RequestBody JoinDto joinDto){
        userService.회원업데이트(id, joinDto);
        return new CMRespDto<>(1, "ok", null);
    }

    @GetMapping("/update")
    public String updateMypage(@RequestParam Integer id, Model model){
        model.addAttribute("user", userService.유저정보보기(id));
        return "page/user/updateMypageForm";
    }

    @GetMapping("/mypage")
    public String viewMypage(@RequestParam Integer id, Model model){
        //Session principal = (Session) session.getAttribute("principal");
        //System.out.println(principal);
        model.addAttribute("user", userService.유저정보보기(id));
        model.addAttribute("resume", userService.이력서보기(id));
        return "page/user/mypage";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "page/user/login";
    }

    @PostMapping("/login")
    public @ResponseBody CMRespDto<?> login(@RequestBody LoginDto loginDto, HttpSession session){
        boolean result = userService.로그인(loginDto);
        if(result==true){
            session.setAttribute("principal", loginDto.getUsername());
        }
        return new CMRespDto<>(1, "1", result);
    }

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

    @GetMapping({"/", "/main"})
    public String main(){
        return "page/main";
    }
}
