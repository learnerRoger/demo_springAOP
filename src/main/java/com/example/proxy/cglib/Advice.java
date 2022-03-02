package com.example.proxy.cglib;

public class Advice {

    /**
     * 在访问真正对象之前后者之后的增强方法
     */
    public void brefore(){
        System.out.println("前置增强。。。。");
    }

    public void afterReturning(){
        System.out.println("后置增强。。。。");
    }
}
