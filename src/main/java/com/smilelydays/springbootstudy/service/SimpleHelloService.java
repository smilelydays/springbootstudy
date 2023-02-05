package com.smilelydays.springbootstudy.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService{
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
