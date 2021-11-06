package com.example.api.controller;



import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Desc: HelloWorldController
 * @Author: jzman
 */
//@controller
//@ResponseBody
@RestController
public class HelloWorldController {

    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping(value = "/message", method = RequestMethod.GET)

    /**
     * @RequestParam(name = "author", defaultValue = "jzman") String author,
     * @RequestParam(name = "message", defaultValue = "Hello world!") String message
     */
    @GetMapping("/helloworld")
    public String message() {
        return String.valueOf(counter.incrementAndGet());
    }

    @RequestMapping(value = "/helloworld2", method = {RequestMethod.GET, RequestMethod.POST})
    public String message2(
            @RequestParam(name = "author") String author,
            @RequestParam(name = "message") String message
    ) {
        return String.valueOf(counter.incrementAndGet()) + author + message;
    }

}