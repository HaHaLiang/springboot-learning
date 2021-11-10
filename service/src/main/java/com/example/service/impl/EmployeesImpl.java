package com.example.service.impl;

import com.example.entity.EmployeesEntity;
import com.example.repository.EmployeesDao;
import com.example.service.EmployeesInterface;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class EmployeesImpl implements EmployeesInterface {
    @Resource
    private EmployeesDao employeesDao;

    @Override
    public EmployeesEntity findById(Long id) {
        Optional<EmployeesEntity> userDOOptional = employeesDao.findById(id);
        if (userDOOptional.isPresent()) {
            return userDOOptional.get();
        }
        return null;
    }
}
