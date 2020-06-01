package com.github.nechai.spring.impl;

import com.github.nechai.spring.IHero;

public class Hero implements IHero {
    @Override
    public void getName() {
        System.out.println(this.getClass().getSimpleName());
    }
}
