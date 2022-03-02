package com.example.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        final Target target = new Target();

        Advice advice = new Advice();
        TargetInterface proxyInstance = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                /**
                 * 标记***
                 */
                (proxy, method, args1) -> {
                    advice.brefore();
                    Object invoke = method.invoke(target, args1);
                    advice.afterReturning();
                    return invoke;
                }
        );
        proxyInstance.save();
    }
}
