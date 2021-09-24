package com.zdj.abstrac;

/**
 * @author zhangdj
 * @date 2020-06-04 17:48
 */
public abstract class Person {
    public Person(){
        System.out.println("construct run ....");
    }

    public abstract void method();
}
