package com.zdj.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangdj
 * @date 2020-06-04 19:53
 */
public class MainTest {
    public static void main(String[] args) {
        CreateThread thread = new CreateThread();
        thread.start();
        MyThread myThread = new MyThread();
        myThread.run();
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(()-> System.out.println("service"));
        service.shutdown();
        CallableThread callableThread = new CallableThread();
        callableThread.call();
    }

    @Test
    public void test(){
        MyThread thread = new MyThread();
        new Thread(thread,"C").start();
        new Thread(thread,"D").start();
    }

    @Test
    public void test2(){
        CreateThread createThread = new CreateThread();
        new Thread(createThread,"c").start();
        new Thread(createThread,"D").start();
    }
}
