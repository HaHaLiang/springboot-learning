package com.example.service.impl;

import com.example.repository.TitlesDao;
import com.example.entity.TitlesEntity;
import com.example.service.TitlesInterface;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;


// NOTE
@Service
public class TitlesServiceImpl implements TitlesInterface {

    @Resource
    private TitlesDao titlesDao;

    @Override
    public TitlesEntity findById(Long id) {
        Optional<TitlesEntity> userDOOptional = titlesDao.findById(id);
        if (userDOOptional.isPresent()) {
            return userDOOptional.get();
        }
        return null;
    }
}
