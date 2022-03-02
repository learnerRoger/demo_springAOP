package com.example.aop;

public class Target implements TargetInterface {

    /**
     *  真正的访问对象
     */
    @Override
    public void save() {
        System.out.println("save is running...");
    }
}
