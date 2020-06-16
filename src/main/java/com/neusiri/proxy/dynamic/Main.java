package com.neusiri.proxy.dynamic;

import org.junit.Test;

/**
 * 动态代理测试类
 *
 * @author zhangdj
 * @date 2020/01/09 16:39
 */
public class Main {

    public static void main(String[] args) {
        MyInterFace interFace = new MyInterFaceImpl();
        MyProxy proxy = new MyProxy();
        proxy.setTarget(interFace);
        Object proxyInstance = proxy.createProxyInstance();
        MyInterFace instance = (MyInterFace) proxyInstance;
        instance.hello();
    }


    @Test
    public void test() {
        //实例化代理类
        MyProxy proxy = new MyProxy();
        //实例化目标累
        MyInterFaceImpl2 myInterFaceImpl2 = new MyInterFaceImpl2();
        //将目标类的引用 放到代理类中
        proxy.setTarget(myInterFaceImpl2);
        MyInterFace interFace = (MyInterFace) proxy.createProxyInstance();
        interFace.method();

    }

}
