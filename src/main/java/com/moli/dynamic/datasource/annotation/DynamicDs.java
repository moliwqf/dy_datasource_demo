package com.moli.dynamic.datasource.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author moli
 * @time 2024-07-19 22:24:48
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicDs {
    /**
     * 哪个数据库
     */
    String datasource() default "master";
}
