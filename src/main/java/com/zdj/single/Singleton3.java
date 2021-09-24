package com.zdj.single;

/**
 * @author zhangdj
 * @date 2020-06-09 11:17
 * 加同步锁 实现线程安全的单例模式
 */
public class Singleton3 {

    public static Singleton3 singleton3 = null;

    private Singleton3() {
        System.out.println(this.getClass().getName() + "---init");
    }

    /**
     * 给整个方法加同步锁，获取实例时，有锁的存在，变成串行执行，效率低
     *
     * @return 单例
     */
    public synchronized static Singleton3 getInstance() {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
