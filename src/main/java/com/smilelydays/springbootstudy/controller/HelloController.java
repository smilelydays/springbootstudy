package com.smilelydays.springbootstudy.controller;

import com.smilelydays.springbootstudy.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequestMapping("/hello")
@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public String hello(String name) {
        if (null == name || name.trim().length() == 0) {
            throw new IllegalArgumentException();
        }

        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
