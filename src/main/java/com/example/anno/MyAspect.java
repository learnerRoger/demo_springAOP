package com.example.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect     //标注当前myaspect类为一个切面类
public class MyAspect {

    @Pointcut("execution(* com.example.anno.*.*(..))")
    public void myaspect(){}


    @Before("myaspect()")
    public void before(){
        System.out.println("前置增强.....");
    }
    @AfterReturning("MyAspect.myaspect()")
    public void afterReturning(){
        System.out.println("后置增强");
    }

    @Around("myaspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕前增强");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后增强");
        return proceed;
    }

    @AfterThrowing("myaspect()")
    public void afterThrowException(){
        System.out.println("抛出异常");
    }

    @After("myaspect()")
    public void after(){
        System.out.println("最终增强。。。。");
    }
}
