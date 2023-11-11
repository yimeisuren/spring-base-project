package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// @Component
// @Aspect
public class MyAspect03 {

    /**
     * 设置对UserService中的所有方法进行增强
     */
    @Pointcut("execution(* org.example.service.UserService.*(..))")
    private void pt2() {
    }

    @Pointcut("execution(* org.example.service.BookService.*(..))")
    private void pt3() {
    }


    /**
     * 通知（需求）：在切入点执行之前输出"hello world! before method: "和当前执行时间
     */
    @Before("pt2()")
    public void myBefore() {
        System.out.println("hello world! before method: " + System.currentTimeMillis());
    }

    @After("pt2()")
    public void myAfter() {
        // 可以进行任何处理，也可以不处理
        System.out.println("hello world! after method: " + System.currentTimeMillis());
        System.out.println("==========================================================");

    }

    @AfterReturning("pt3()")
    public void myAfterReturning() {
        System.out.println("hello world! afterReturning method: " + System.currentTimeMillis());
    }

    @AfterThrowing("pt3()")
    public void myAfterThrowing() {
        System.out.println("hello world! afterThrowing method: " + System.currentTimeMillis());
    }

    // 实际上是一个MethodInvocationProceedingJoinPoint类型
    @Around("pt2()")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("!!!!!!!!!!!!!!!!!!hello world! around method: " + System.currentTimeMillis());
        // 表示对原始方法的调用

        Object target = joinPoint.proceed();

        Signature methodSignature = joinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("正在执行：" + methodName);

        Object[] args = joinPoint.getArgs();
        Object proxy = joinPoint.getTarget();
        Class<?> clazz = proxy.getClass();

        System.out.println("joinPoint.getClass() = " + joinPoint.getClass());
        System.out.println("!!!!!!!!!!!!!!!!!!hello world! around method: " + System.currentTimeMillis());
        return target;
    }
}
