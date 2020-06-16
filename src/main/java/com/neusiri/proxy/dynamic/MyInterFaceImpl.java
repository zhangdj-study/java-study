package com.neusiri.proxy.dynamic;

/**
 * 被代理类1
 * @author zhangdj
 * @date 2020/01/09 16:38
 */
public class MyInterFaceImpl implements MyInterFace{

    @Override
    public void hello() {
        System.out.println("MyInterFaceImpl");
    }

    @Override
    public void method() {
        System.out.println("MyInterFaceImpl-method");
    }
}
