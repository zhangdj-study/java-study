package com.zdj.single;

/**
 * @author zhangdj
 * @date 2020-06-09 10:12
 * 饿汉式单例模式 加载类的时候就实例化
 * 线程安全
 * 无论是否需要该对象 都会进行实例化 会造成资源浪费
 */
public class Singleton0 {

    public static final Singleton0 instance = new Singleton0();

    /**
     * 私有构造方法防止 其他类对单例类实例化
     */
    private Singleton0() {
        System.out.println(this.getClass().getName() + "---init");
    }


    public static Singleton0 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton0 instance = Singleton0.getInstance();
        System.out.println(instance);
    }
}
