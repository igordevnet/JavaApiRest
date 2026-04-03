package com.example.jobapi.aop;

import com.example.jobapi.JobApiApplication;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.example.jobapi.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint joinPoint, int postId) throws Throwable {
         if(postId < 0) {
             LOGGER.info("postId is negative, updating it");
             postId = -postId;
             LOGGER.info("new value " + postId);
         }

         Object process = joinPoint.proceed(new Object[]{postId});

        return process;
    }
}
