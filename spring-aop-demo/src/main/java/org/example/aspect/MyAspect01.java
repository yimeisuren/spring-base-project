package org.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// @Aspect
// @Component
public class MyAspect01 {
    @Pointcut("@annotation(org.example.annotation.Pt01)")
    private void pt1() {
    }

    @Before("pt1()")
    public void before() {
        System.out.println("************ method before, annotation *****************");
    }
}
