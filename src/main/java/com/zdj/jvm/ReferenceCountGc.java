package com.zdj.jvm;

/**
 * @author zhangdj
 * @date 2021/04/26
 */
public class ReferenceCountGc {

    public Object instance;

    private static final int _1MB = 1024 * 1024;

    /**
     * 占用内存 便于观察GC日志中的对象是否被回收
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountGc referenceCountGcA = new ReferenceCountGc();
        ReferenceCountGc referenceCountGcB = new ReferenceCountGc();
        referenceCountGcA.instance = referenceCountGcB;
        referenceCountGcB.instance = referenceCountGcA;

        referenceCountGcA = null;
        referenceCountGcB = null;

        System.gc();
    }
}
