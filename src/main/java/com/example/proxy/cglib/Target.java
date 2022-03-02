package com.example.proxy.cglib;

public class Target{

    /**
     *  真正的访问对象
     */
    public void save() {
        System.out.println("save is running...");
    }
}
