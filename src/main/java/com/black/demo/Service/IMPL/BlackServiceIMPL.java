package com.black.demo.Service.IMPL;

import com.black.demo.Service.BlackService;
import org.springframework.stereotype.Component;

@Component
public class BlackServiceIMPL implements BlackService {
    @Override
    public String ifKids(int age) {
        if (age < 18) {
            return "aniketh will smash";
        } else {
            return "aniketh will pass";
        }
    }
}
