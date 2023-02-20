package com.smilelydays.springbootstudy.service;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Test
@interface UnitTest {
}

class SimpleHelloServiceTest {
    @UnitTest
    void say_hello_test() {
        SimpleHelloService helloService = new SimpleHelloService();
        String result = helloService.sayHello("Test");

        assertThat(result).isEqualTo("Hello Test");
    }
}