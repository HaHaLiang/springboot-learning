package com.example.api.controller;

import com.example.entity.EmployeesEntity;
import com.example.service.impl.EmployeesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeesController {

    @Autowired
    private EmployeesImpl employeesService;

    @RequestMapping(value = "/findById", method = {RequestMethod.GET, RequestMethod.POST})
    public EmployeesEntity findByID(@RequestParam(name = "id") long id) {
        return employeesService.findById(id);
    }
}
