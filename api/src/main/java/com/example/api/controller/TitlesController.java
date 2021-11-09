package com.example.api.controller;


import com.example.entity.TitlesEntity;
import com.example.service.impl.TitlesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/titles")
public class TitlesController {

    @Autowired
    private TitlesServiceImpl titlesService;

    @RequestMapping(value = "/findById", method = {RequestMethod.GET, RequestMethod.POST})
    public TitlesEntity findById(@RequestParam(name = "id") Long id) {
        return titlesService.findById(id);
    }
}