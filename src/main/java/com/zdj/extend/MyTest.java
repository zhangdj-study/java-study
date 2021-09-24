package com.zdj.extend;

/**
 * @author zhangdj
 * @date 2020-06-05 17:50
 */
public class MyTest {

    @org.junit.Test
    public void test(){
        // 拥有了子类函数覆盖后的父类对象
        Father f1 = new Son();
        Father f2 = new Father();
        Son son = new Son();
        System.out.println(f1.name);
        f1.eat();
        System.out.println(f2.name);
        f2.eat();
        System.out.println(son.name);
        son.eat();
    }

}
