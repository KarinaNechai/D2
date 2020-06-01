package com.github.nechai.spring.impl;

import com.github.nechai.spring.TimeAnnotation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TimeBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> mapBeanClass = new HashMap<>();
    private Map<String,List<String>> mapBeanMethod = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Method[] beanMethod = bean.getClass().getDeclaredMethods();
        Boolean flag = false;
        List<String> list=new ArrayList();
        for (Method m : beanMethod
        ) {
            if (m.isAnnotationPresent(TimeAnnotation.class)) {
                list.add(m.getName());
               flag = true;
            }
        }
        if (flag) {
            mapBeanClass.put(beanName, beanClass);
            mapBeanMethod.put(beanName,list);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = mapBeanClass.get(beanName);
        if (beanClass != null) {
            InvocationHandler i = new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    {
                        if (mapBeanMethod.get(beanName).contains(method.getName())) {
                            System.out.println("Start ...");
                            long start = System.nanoTime();
                            System.out.println(method.getName());
                            Object o = method.invoke(bean, args);
                            long end = System.nanoTime();
                            System.out.println(end - start);
                            System.out.println("Finish ...");
                            return o;
                        } else return method.invoke(bean, args);
                    }
                }
            };
            Object p = Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), i);
            System.out.println();
            return p;
        }
        return bean;
    }
}
