package com.example.demo.dao.annotation;

import com.example.demo.dao.Enum.OperationType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lbs
 * @dete
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /* 要执行的操作类型比如： add操作 */
    public OperationType operationType() default OperationType.UNKNOW;

    /* 要执行的具体操作比如; 添加用户* */
    public String operationName() default "";

}
