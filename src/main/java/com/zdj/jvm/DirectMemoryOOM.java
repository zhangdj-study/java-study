package com.zdj.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author zhangdj
 * @date 2021/04/25
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        int i = 0;
        while (true) {
            System.out.println(++i);
            // 申请分配内存
            unsafe.allocateMemory(_1MB);
        }
    }

}
