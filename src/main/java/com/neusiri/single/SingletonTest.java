package com.neusiri.single;

import org.junit.Test;

/**
 * @author zhangdj
 * @date 2020-06-09 14:10
 */
public class SingletonTest {

    /**
     * 100000个线程
     */
    public static final int CYCLE_INDEX = 100000;

    @Test
    public void singleton() {
        Runnable runnable = () -> {
//            Singleton0.getInstance();
//            Singleton1.getInstance();
//            Singleton2.getInstance();
//            Singleton3.getInstance();
            Singleton4.getInstance();
        };
        for (int i = 0; i < CYCLE_INDEX; i++) {
            new Thread(runnable).start();
        }
    }
}
