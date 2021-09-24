package com.zdj.instanceoftest;

import org.junit.Test;

/**
 * @author zhangdj
 * @date 2019/9/25
 */
public class InstanceofTest {

    @Test
    public void test(){
        B b = new C();
        System.out.println(b instanceof C);
    }
}


interface A{}
class B implements A{}
class C extends B{}
