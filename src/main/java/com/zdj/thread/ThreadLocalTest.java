package com.zdj.thread;

/**
 * @author zhangdj
 * @date 2020/10/13
 */
public class ThreadLocalTest {

    static ThreadLocal<Long> x = ThreadLocal.withInitial(() -> {
        System.out.println("init");
        return Thread.currentThread().getId();
    });

    public static void main(String[] args) {
        new Thread(() -> System.out.println(x.get())).start();


        System.out.println(x.get());
    }
}
