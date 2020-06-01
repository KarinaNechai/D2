package com.github.nechai.spring;

import com.github.nechai.spring.impl.IronMan;
import org.springframework.context.annotation.Bean;

public class ContextConfiguration {
    @Bean
    public IronMan ironMan() {
        return new IronMan();
    }
}
