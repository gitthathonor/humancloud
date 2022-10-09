package site.metacoding.humancloud.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserAPIController {

    private final UserService userService;

    @GetMapping("/user/api/mypage")
    public void viewMypage(){
//        System.out.println("------------------------");
//        System.out.println(userService.유저정보보기(1).getPhoneNumber());
//        System.out.println(userService.관심분야목록(1).get(1));
//
//        userService.메인페이지구성(1);
        // List<Map<String, Object>> categoryPS = new ArrayList<>();
        // Map sample = new HashMap<>();
        // sample.put("key", "data");
        // sample.put("key2", "data2");


        // categoryPS.add(sample);
        // System.out.println(categoryPS.get(0).get("key"));
    }
}
