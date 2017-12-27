package com.catcher92.blog.aop;

import com.catcher92.blog.exception.ParamException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

@Aspect
@Component
public class ValidateExceptionAop {

    @Pointcut("execution(* com.catcher92.blog.service.*.*(..))")
    public void violationException() {}

    @AfterThrowing(pointcut = "violationException()", throwing = "e")
    public void handleException(ConstraintViolationException e) {
        Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
        ConstraintViolation<?> violation;
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            violation = iterator.next();
            builder.append(violation.getMessage());
            builder.append(" ");
        }
        throw new ParamException(builder.toString());
    }
}
