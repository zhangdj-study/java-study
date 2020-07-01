package com.neusiri.single;

/**
 * @author zhangdj
 * @date 2020-06-09 10:16
 * 静态内部类 实现线程安全的单例模式
 * 静态内部类实例化单例对象，需要该单例对象的时候，调用getInstance()方法，会加载内部类，完成单例对象的初始化，并将实例返回
 */
public class Singleton1 {

    private Singleton1() {
        System.out.println(this.getClass().getName() + "---init");
    }

    /**
     * 由静态内部类实例化单例对象
     */
    private static class Inner {
        public static final Singleton1 singleton1 = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return Inner.singleton1;
    }

    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        System.out.println(instance);
    }
}


