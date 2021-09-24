package com.zdj.lambda.innerclass;

/**
 * @author zhangdj
 * @date 2021/08/06
 */
public class InnerClassTest {

    public static String s = "123";

    public static void main(String[] args) {
        String str="haha";
        String finalStr = str;
        new Thread() {
            @Override
            public void run() {
                System.out.println(finalStr);
            }
        }.start();

        str = "123";

    }
}
