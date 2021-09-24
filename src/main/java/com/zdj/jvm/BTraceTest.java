package com.zdj.jvm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author zhangdj
 * @date 2021/05/31
 * BTrace插件测试
 */
public class BTraceTest {

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 1000; i++) {
            bufferedReader.readLine();
            int a = (int )Math.round(Math.random() * 1000);
            int b = (int )Math.round(Math.random() * 1000);
            System.out.println(add(a, b));
        }
    }
}
