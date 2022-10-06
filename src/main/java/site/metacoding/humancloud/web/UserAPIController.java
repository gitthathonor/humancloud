package site.metacoding.humancloud.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserAPIController {

    private final UserService userService;

    @GetMapping("/user/api/mypage")
    public void viewMypage(){
        // return userService.유저정보보기(1);
    }
}
