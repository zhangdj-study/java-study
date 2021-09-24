package com.zdj.string;

import org.junit.Test;

/**
 * @author zhangdj
 * @date 2019/10/8
 */
public class MyTest {

    @Test
    public void test1() throws Exception{
        String s = "123.txt";
        String[] strings = s.split("\\.");
        System.out.println(strings.length);
        for (String s2:strings) {
            System.out.println(s2);
        }
    }
}
