package com.example.demo.controller.aspect;

import com.example.demo.dao.Enum.OperationType;
import com.example.demo.dao.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 日志切面类
 * @author lbs
 * @dete
 */
@Aspect
@Component
public class SystemLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    @Autowired
    private HttpServletRequest request;

    //Controller层切点
    @Pointcut(value = "execution(* com.example.demo.controller.cpts.*.*(..))")
    public void controllerAspect() {

    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint point) throws Throwable{
        logger.info("------------------------------controller start------------------------------------");
        Signature signature = point.getSignature();//方法签名
        MethodSignature methodSignature = (MethodSignature)signature;
        Method method = methodSignature.getMethod();
        //目标对象上有注解的方法
        Method relMethod = point.getTarget().getClass().getDeclaredMethod(signature.getName(), method.getParameterTypes());
        //获取方法上的注解
        Log annotation = relMethod.getAnnotation(Log.class);
        if(annotation != null){
            OperationType operationType = annotation.operationType();
            String operationName = annotation.operationName();
            logger.info("operationType:[{}]", operationType);
            logger.info("operationName:【{}】", operationName);
        }

        System.out.println(point);

        logger.info("-------------------------------controller end-------------------------------------------");
    }

    @Around("controllerAspect()")
    public void aroundControllerAspect(ProceedingJoinPoint joinPoint) {
        // 获取方法名称
        String methodName = joinPoint.getSignature().getName();
        // 获取入参
        Object[] params = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object o : params) {
            sb.append(o + ";");
        }
        logger.info("进入["+ methodName +"]方法，参数为：" + sb.toString());
        //继续执行方法
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("[{}]方法执行结束", methodName);
    }
}
