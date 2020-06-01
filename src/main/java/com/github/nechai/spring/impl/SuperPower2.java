package com.github.nechai.spring.impl;

import com.github.nechai.spring.ISuperPower;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("s2")
public class SuperPower2 implements ISuperPower {
    @Override
    public void getName(String hero) {
        System.out.println("Add superpower of" +hero);
    }
}
