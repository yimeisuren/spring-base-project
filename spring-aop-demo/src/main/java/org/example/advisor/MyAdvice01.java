package org.example.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 该通知类实现的需求是：计算方法的十万次执行耗时
 */
public class MyAdvice01 implements MethodInterceptor {

    /**
     * 这里就是@Around中的处理方式
     * <p>
     * MethodInvocation是封装了原始方法（连接点）
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        long begin = System.currentTimeMillis();
        Method method = invocation.getMethod();
        Object result = invocation.proceed();
        for (int i = 0; i < 100000; i++) {
            invocation.proceed();
        }
        long end = System.currentTimeMillis();
        System.out.println(method.getName() + "方法的100000次执行耗时: " + (end - begin) + "ms");
        return result;
    }
}
