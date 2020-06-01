package com.github.nechai.spring.impl;

import com.github.nechai.spring.IHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Wolverine extends Hero {
    SuperPower superPower;

    @Autowired
    public Wolverine(SuperPower superPower) {
        this.superPower = superPower;
    }

    public SuperPower getSuperPower() {
        return superPower;
    }

    public void setSuperPower(SuperPower superPower) {
        this.superPower = superPower;
    }
}
