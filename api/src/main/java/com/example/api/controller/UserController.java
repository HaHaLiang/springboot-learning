package com.example.api.controller;



import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/queryUserInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String message2(
            @RequestParam(name = "uid") String uid) {
        return "张三 20岁 男";

    }
}