package com.smilelydays.springbootstudy.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleHelloServiceTest {
    @Test
    void say_hello_test() {
        SimpleHelloService helloService = new SimpleHelloService();
        String result = helloService.sayHello("Test");

        assertThat(result).isEqualTo("Hello Test");
    }
}