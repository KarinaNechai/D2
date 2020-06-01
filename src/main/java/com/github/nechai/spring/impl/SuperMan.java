package com.github.nechai.spring.impl;

import com.github.nechai.spring.IHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuperMan extends Hero {
    SuperPower superPower;

    public SuperPower getSuperPower() {
        return superPower;
    }

    @Autowired
    public void setSuperPower(SuperPower superPower) {
        this.superPower = superPower;
    }
}
