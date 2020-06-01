package com.github.nechai.spring.impl;

import com.github.nechai.spring.ISuperPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Phoenix extends Hero {
    @Autowired
    @Qualifier(value = "s1")
    ISuperPower superPower1;

    @Autowired
    @Qualifier(value = "s2")
    ISuperPower superPower2;

    public ISuperPower getSuperPower1() {
        return superPower1;
    }

    public void setSuperPower1(ISuperPower superPower1) {
        this.superPower1 = superPower1;
    }

    public ISuperPower getSuperPower2() {
        return superPower2;
    }

    public void setSuperPower2(ISuperPower superPower2) {
        this.superPower2 = superPower2;
    }
}
