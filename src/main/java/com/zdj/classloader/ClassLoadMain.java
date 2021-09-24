package com.zdj.classloader;

import com.sun.crypto.provider.DESKeyFactory;

/**
 * @author zhangdj
 * @date 2021/02/01
 */
public class ClassLoadMain {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        // ExtClassLoader 加载jre/lib/ext下面的jar包下的类
        System.out.println(DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(ClassLoadMain.class.getClassLoader().getClass().getName());
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
    }
}
