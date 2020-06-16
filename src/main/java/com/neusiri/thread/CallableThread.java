package com.neusiri.thread;

import java.util.concurrent.Callable;

/**
 * @author zhangdj
 * @date 2020-06-04 20:16
 */
public class CallableThread implements Callable {
    @Override
    public Object call() {
        System.out.println("call thread....");
        return null;
    }
}
