package com.moli.dynamic.datasource.aspect;

import com.moli.dynamic.datasource.annotation.DynamicDs;
import com.moli.dynamic.datasource.context.DynamicDatasourceHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author moli
 * @time 2024-07-19 22:25:51
 */
@Aspect
@Component
public class DynamicDsAspect {

    @Pointcut("@annotation(com.moli.dynamic.datasource.annotation.DynamicDs)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        // 默认 master
        String datasource = "master";
        // 类上的注解
        Class<?> targetClass = joinPoint.getTarget().getClass();
        DynamicDs annotation = targetClass.getAnnotation(DynamicDs.class);

        if (Objects.nonNull(annotation))
            datasource = annotation.datasource();
        // 方法上的注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DynamicDs annotationMethod = methodSignature.getMethod().getAnnotation(DynamicDs.class);
        if (Objects.nonNull(annotationMethod))
            datasource = annotationMethod.datasource();

        // 设置数据源
        DynamicDatasourceHolder.setDataSource(datasource);
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException("运行错误");
        } finally {
            DynamicDatasourceHolder.removeDatasource();
        }
    }
}
