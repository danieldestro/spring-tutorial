package com.example.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class AnotherService {

    public void callMeMayBe() {
        System.out.println("call me may be");
    }
}
