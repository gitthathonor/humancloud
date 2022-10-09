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

    @GetMapping("test/login")
    public void testlogin(){

    }
}
