package com.example.anno;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {

    /**
     *  真正的访问对象
     */
    @Override
    public void save() {
//        int i = 1 / 0;
        System.out.println("save is running...");
    }
}
