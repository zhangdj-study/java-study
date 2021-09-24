package com.zdj.proxy.staticproxy;

/**
 * 静态代理类 需要实现被代理对象实现的接口
 * @author zhangdj
 * @date 2020/01/09 17:40
 */
public class StaticProxy implements StaticProxyInterface{

    /**
     * 被代理对象
     */
    private StaticProxyInterfaceImpl1 staticProxyInterfaceImpl1;

    public StaticProxy(StaticProxyInterfaceImpl1 staticProxyInterfaceImpl1){
        this.staticProxyInterfaceImpl1 = staticProxyInterfaceImpl1;
    }

    @Override
    public void method1() {
        staticProxyInterfaceImpl1.method1();
    }

    @Override
    public void method2() {
        staticProxyInterfaceImpl1.method2();
    }
}
