package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.omg.CORBA.PUBLIC_MEMBER;

public class MyAspect {

    //public void before(){
        //System.out.println("前置增强.....");
    //}

    //public void afterReturning(){
        //System.out.println("后置增强");
    //}
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕前增强");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后增强");
        return proceed;
    }

    public void afterThrowException(){
        System.out.println("抛出异常");
    }

    public void after(){
        System.out.println("最终增强。。。。");
    }
}
