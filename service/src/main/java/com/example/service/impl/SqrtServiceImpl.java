package com.example.service.impl;

import com.example.service.SqrtInterface;
import org.springframework.stereotype.Service;


// NOTE
@Service
public class SqrtServiceImpl implements SqrtInterface {

    public int getSqrtVal(int x) {
        return x * x;
    }

}
