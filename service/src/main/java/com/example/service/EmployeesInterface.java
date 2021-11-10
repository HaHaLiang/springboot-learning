package com.example.service;

import com.example.entity.EmployeesEntity;
import com.example.repository.EmployeesDao;

public interface EmployeesInterface {
    EmployeesEntity findById(Long id);
}
