package com.example.proxy.cglib;

import com.example.proxy.jdk.TargetInterface;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyTest {
    public static void main(String[] args) {
        final Target target = new Target();

        Advice advice = new Advice();
        /**
         * 基于cglib动态生成代理
         *
         * 1、创建增强器
         * 2、设置父类（目标）
         * 3、设置回调
         * 4、c创建代理对象
         */

        Enhancer enhance = new Enhancer();
        enhance.setSuperclass(Target.class);
        enhance.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            /**
             * 执行前置
             */

            advice.brefore();
            /**
             * 执行方法
             */
            Object invoke = method.invoke(target,args);
            /**
             * 执行后置
             */
            advice.afterReturning();
            return invoke;
        });
        Target proxy = (Target) enhance.create();
        proxy.save();
    }
}
