package com.mark.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {
    //真实对象
    private Object target = null;
    /**
     * 代理对象
     *
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws
            Throwable {
        System.out.println("进入代理逻辑方法 ");
        System.out.println("在调度真实对象之前的服务");
        Object obj = method.invoke(target, args);//相当于调用 sayHelloWorld
        System.out.println("在调度真实对象之后 的服务 ");
        return obj;
    }
}