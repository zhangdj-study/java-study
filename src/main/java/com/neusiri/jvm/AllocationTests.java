package com.neusiri.jvm;

import org.junit.Test;

/**
 * @author zhangdj
 * @date 2021/05/17
 */
public class AllocationTests {

    private static final int _1MB = 1024 * 1024;

    /**
     * -XX:+UseParNewGC 使用ParNew收集器
     * -XX:+PrintGCDetails
     * -Xms20M  初始堆内存
     * -Xmx20M  最大堆内存
     * -Xmn10M  新生代大小
     * -XX:SurvivorRatio=8
     */
    @Test
    public void allocationTest() {
        byte[]  allocation1,  allocation2,  allocation3,  allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * -XX:PretenureSizeThreshold=3145728
     * 大于3M的对象直接进入老年代
     * 该参数只会Serial和ParNew两款收集器有效
     *
     * -XX:+UseParNewGC
     * -XX:+PrintGCDetails
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    @Test
    public void pretenureTest() {
        byte[]  allocation1;
        allocation1 = new byte[4 * _1MB];
    }

    @Test
    public void tenuringThresholdTest() {
        byte[]  allocation1,  allocation2,  allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
    }

    @Test
    public void tenuringThresholdTest2() {
        byte[]  allocation1,  allocation2,  allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        // allocation1 + allocation2 大于survivor空间的一半
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    @Test
    public void handlePromotionTest() {
        byte[]  allocation1,  allocation2,  allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }
}
