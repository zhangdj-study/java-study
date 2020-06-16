package com.neusiri.thread;

/**
 * @author zhangdj
 * @date 2020-06-04 19:53
 */
public class CreateThread extends Thread{
    @Override
    public void run(){
        String s = "123";
        System.out.println("create thread is running" + s + Thread.currentThread().getName());
    }
}
