package com.github.nechai.spring.impl;

import com.github.nechai.spring.ISuperPower;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "s1")
public class SuperPower implements ISuperPower {
    @Override
    public void getName(String hero) {
        System.out.println("SuperPower of "+hero);

    }
}
