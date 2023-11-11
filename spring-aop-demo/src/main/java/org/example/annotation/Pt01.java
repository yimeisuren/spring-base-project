package org.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
// 这里尝试允许定义在类上，但是@Pointcut中的annotation并不会出现@Pt01定义在类上的情况，因此即使允许定义在类上，也不会生效
// @Target({ElementType.METHOD, ElementType.TYPE})
public @interface Pt01 {
}
