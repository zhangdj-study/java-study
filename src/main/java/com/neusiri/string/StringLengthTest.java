package com.neusiri.string;

import org.junit.Test;

/**
 * @author zhangdj
 * @date 2019/9/4
 */
public class StringLengthTest {
    public static void main(String[] args) {

        String str = "1234567890";

        while (str.length() < 65530099 && str.trim().length() > 0) {
            System.out.println("字符串长度: " + str.length());
            str += str;
        }
    }

    @Test
    public void test(){
        String s = "123,1，23";
        String s1 = s.replaceAll(",", ";").replaceAll("，",";");
        System.out.println(s);
        System.out.println(s1);
    }
}
