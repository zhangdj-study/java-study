package com.neusiri.thread;

import org.junit.Test;

/**
 * @author zhangdj
 * @date 2020-06-04 19:59
 */
public class MyThread implements Runnable{
    @Override
    public void run() {
        int i=1;
        System.out.println("my thread is running" + i + Thread.currentThread().getName());
    }
}
