package com.zdj.private_test;

import lombok.Data;

/**
 * @author zhangdj
 * @date 2021/03/05
 */
@Data
public class A {

    private Long id;

    private A a = new A();

    public void mm() {
        a.m();
    }

    private void m() {
        a.setId(123L);
        System.out.println("123");
    }
}
