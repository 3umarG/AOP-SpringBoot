package com.aop.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(SecurityAspect.class);

    @Around(value = "@annotation(com.aop.demo.annotations.SecureAndCache)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.error("Start applying Security Aspects for : -"+joinPoint.getSignature().getName()+"- .");

        Object returnedValue = joinPoint.proceed();

        LOGGER.error("Finishing the proceed method ");

        return returnedValue + " SECURED";
    }
}
