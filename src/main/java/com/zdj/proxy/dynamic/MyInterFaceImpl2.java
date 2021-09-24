package com.zdj.proxy.dynamic;

/**
 * 被代理类2
 * @author zhangdj
 * @date 2020/01/09 17:12
 */
public class MyInterFaceImpl2 implements MyInterFace{
    @Override
    public void hello() {
        System.out.println("MyInterFaceImpl2");
    }

    @Override
    public void method() {
        System.out.println("MyInterFaceImpl2-method");
    }
}
