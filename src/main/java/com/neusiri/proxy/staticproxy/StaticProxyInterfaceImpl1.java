package com.neusiri.proxy.staticproxy;

/**
 * 被代理的对象
 * @author zhangdj
 * @date 2020/01/09 17:39
 */
public class StaticProxyInterfaceImpl1 implements StaticProxyInterface{
    @Override
    public void method1() {
        System.out.println("StaticProxyInterfaceImpl1-method1");
    }

    @Override
    public void method2() {
        System.out.println("StaticProxyInterfaceImpl1-method2");
    }
}
