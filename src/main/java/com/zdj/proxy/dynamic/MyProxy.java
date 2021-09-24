package com.zdj.proxy.dynamic;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * @author zhangdj
 * @date 2020/01/09 16:38
 */
@Data
public class MyProxy implements InvocationHandler {

    /**
     * 需要代理的目标类
     */
    private Object target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强");
        Object result = method.invoke(target, args);
        return result;
    }

    /**
     * 生成目标类的实例
     * @return
     */
    public Object createProxyInstance(){
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return o;

    }
}
