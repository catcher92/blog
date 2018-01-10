package com.catcher92.blog.aop;

import com.catcher92.blog.exception.ParamException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintViolationException;

@Aspect
@Component
public class ValidateExceptionAop {

    @Pointcut("execution(* com.catcher92.blog.service.*.*(..))")
    public void violationException() {}

    @AfterThrowing(pointcut = "violationException()", throwing = "e")
    public void handleException(ConstraintViolationException e) {
        throw new ParamException(StringUtils.join(e.getConstraintViolations(), ","));
    }
}
