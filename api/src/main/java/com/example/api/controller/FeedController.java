package com.example.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController("/feed")
public class FeedController {

    @RequestMapping(value = "/fetchFeeds", method = {RequestMethod.GET, RequestMethod.POST})
    public String message2(
            @RequestParam(name = "author") String uid) {
        return "最新新闻!!!!";

    }
}