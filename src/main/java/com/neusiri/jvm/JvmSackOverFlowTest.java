package com.neusiri.jvm;

/**
 * @author zhangdj
 * @date 2021/04/25
 */
public class JvmSackOverFlowTest {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JvmSackOverFlowTest test = new JvmSackOverFlowTest();
        try {
            test.stackLeak();
        } catch (Throwable e) {
            System.out.println(test.stackLength);
            throw e;
        }
    }
}
