package com.service.presentation;

import com.service.application.UserService;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("Duplicates")
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return this.userService.testMethod();
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "password") String password) {

        return userService.login(userName, password);
    }

    @GetMapping("/signup")
    public String signup(@RequestParam(value = "userName") String userName,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "email") String email) {

        return userService.signup(userName, password, email);
    }
}
