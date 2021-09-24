package com.zdj.classloader;

/**
 * @author zhangdj
 * @date 2021/02/01
 * JVM指定参数-verbose:class查看类加载过程
 */
public class DynamicClassLoad {

    static {
        System.out.println("static");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("main");
        new B();
    }
}


class A {
    public A() {
        System.out.println("A");
    }
}

class B {
    public B() {
        System.out.println("B");
    }
}
