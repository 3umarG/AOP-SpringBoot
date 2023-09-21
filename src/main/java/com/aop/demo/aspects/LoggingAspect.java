package com.aop.demo.aspects;

import com.aop.demo.entities.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object[] params = joinPoint.getArgs();

        LOGGER.error("Start Logging method : '" + methodName + "` with actual parameters list : " + Arrays.toString(params));

        Comment newComment = new Comment("Updated Comment From Aspect", "New Author from Aspect");
        Object[] newParams = {newComment};

        Object result = joinPoint.proceed(newParams); // executing method after change the parameters.

        LOGGER.error("Finished Logging from Aspect with updated result : "+result);

        return "FAILED";
    }
}
