package com.zdj.single;

/**
 * @author zhangdj
 * @date 2020-06-09 10:27
 * 懒汉式 单例模式 用到该实例才会实例化 线程不安全
 */
public class Singleton2 {

    public static Singleton2 singleton2 = null;

    private Singleton2() {
        System.out.println(this.getClass().getName() + "---init");
    }

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                Singleton2 threadInstance = Singleton2.getInstance();
                System.out.println(threadInstance + Thread.currentThread().getName() + "--" + i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                Singleton2 threadInstance = Singleton2.getInstance();
                System.out.println(threadInstance + Thread.currentThread().getName() + "--" + i);
            }
        }).start();
    }
}
