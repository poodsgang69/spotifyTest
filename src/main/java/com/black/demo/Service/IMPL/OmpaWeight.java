package com.black.demo.Service.IMPL;

import com.black.demo.Service.BlackService;
import org.springframework.stereotype.Component;

@Component
public class OmpaWeight implements BlackService {

    @Override
    public String ifKids(int age) {
        if(age % 10 == 0) {
            return "omba weight";
        }
        return "normal weight";
    }
}
