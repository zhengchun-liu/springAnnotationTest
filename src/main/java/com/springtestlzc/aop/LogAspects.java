package com.springtestlzc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class LogAspects {

    @Pointcut("execution(public int com.springtestlzc.aop.MathCalculator.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(""+ joinPoint.getSignature().getName() +"Before方法被调用前....，调用参数"+ Arrays.asList(args).toString());
    }

    @After("com.springtestlzc.aop.LogAspects.pointCut()")
    public void logEnd() {
        System.out.println("After方法结束。。。。");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("Return方法结束。。。。,运行结果" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(Exception e) {
        System.out.println("Exception方法结束。。。异常信息" + e);
    }
}
