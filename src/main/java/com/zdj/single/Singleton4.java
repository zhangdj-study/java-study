package com.zdj.single;

/**
 * @author zhangdj
 * @date 2020-06-09 14:25
 * 双重检查锁
 */
public class Singleton4 {

    /**
     * volatile修饰的变量不允许线程内部缓存和重排序
     */
    private static volatile Singleton4 singleton4 = null;

    private Singleton4() {
        System.out.println(this.getClass().getName() + "---init");
    }


    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
