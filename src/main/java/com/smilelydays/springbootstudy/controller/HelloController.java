package com.smilelydays.springbootstudy.controller;

import com.smilelydays.springbootstudy.service.HelloService;

public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        return helloService.sayHello(name);
    }
}
