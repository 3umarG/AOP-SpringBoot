package com.aop.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // methods that match :
    // * = any return type
    // com.aop.demo.services.. = any sub-package inside this path
    // * = any class within the path
    // .* = any method in the class
    // (..) = any parameter list with any type
    @Around(value = "execution(* com.aop.demo.services..*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
       LOGGER.error("Start Logging form Aspect.");
       joinPoint.proceed();
       LOGGER.error("Finished Logging from Aspect.");
    }
}
