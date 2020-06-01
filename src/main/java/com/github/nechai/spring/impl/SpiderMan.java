package com.github.nechai.spring.impl;

import com.github.nechai.spring.TimeAnnotation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("hero.properties")
public class SpiderMan extends Hero {
    @Value("${heroAge}")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getTime() {
        System.out.println("Method with TimeAnnotation");
    }
}
