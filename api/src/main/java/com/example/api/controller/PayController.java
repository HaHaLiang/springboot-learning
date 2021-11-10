package com.example.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/payment")
public class PayController {

    @RequestMapping(value = "/queryPayAccount", method = {RequestMethod.GET, RequestMethod.POST})
    public String message2(
            @RequestParam(name = "author") String uid) {
        return "支付宝余额 1 亿元";

    }
}