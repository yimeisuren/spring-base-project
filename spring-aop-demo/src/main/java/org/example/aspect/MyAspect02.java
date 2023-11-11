package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class MyAspect02 {

    /**
     * 设置对UserService中的所有方法进行增强
     */
    @Pointcut("execution(* org.example.service.UserService.*(..))")
    private void pt2() {
    }


    // @Before("pt2()")
    // public void before() {
    //     System.out.println("hello world! before method: " + System.currentTimeMillis());
    // }
    //
    // @After("pt2()")
    // public void after() {
    //     // 可以进行任何处理，也可以不处理
    //     System.out.println("hello world! after method: " + System.currentTimeMillis());
    //     System.out.println("==========================================================");
    // }

    @Around("pt2()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        long begin = System.currentTimeMillis();
        result = joinPoint.proceed();
        for (int i = 0; i < 100 - 1; i++) {
            joinPoint.proceed();
        }
        long end = System.currentTimeMillis();

        String methodName = joinPoint.getSignature().getName();

        System.out.println(methodName + " : " + (end - begin));
        return result;
    }
}
