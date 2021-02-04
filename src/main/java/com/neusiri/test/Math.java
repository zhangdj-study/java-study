package com.neusiri.test;

/**
 * @author zhangdj
 * @date 2021/02/01
 */
public class Math {

    public int math() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        int value = math.math();
        System.out.println(value);
    }

}
