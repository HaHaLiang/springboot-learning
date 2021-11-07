package com.example.api.controller;


import com.example.client.SqrtUtil;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;


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
            @RequestParam(name = "message") String message) {
        return String.valueOf(counter.incrementAndGet()) + author + message;
    }

    @RequestMapping(value = "/sqrt", method = {RequestMethod.GET, RequestMethod.POST})
    public String sqrt(@RequestParam(name = "value") Integer value) {
        return String.valueOf(SqrtUtil.getSqrtVal(value));
    }


}