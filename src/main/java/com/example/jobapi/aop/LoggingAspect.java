package com.example.jobapi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.jobapi.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        LOGGER.info("Logging aspect called " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.jobapi.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint joinPoint) {
        LOGGER.info("Method executed " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.jobapi.service.JobService.getJob(..))")
    public void logMethodException(JoinPoint joinPoint) {
        LOGGER.error("Method has some issues " + joinPoint.getSignature().getName());
    }
}
