package com.zdj.hashcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author zhangdj
 * @date 2020-01-20 11:24
 */
public class Main {

    /**
     * 向hashMap中放入对象时，会根据这个类的hashCode计算hash值，将key和value放入hash值指引的内存位置
     */
    @Test
    public void test(){
        Key k1 = new Key(1);
        Key k2 = new Key(1);
        HashMap<Key,String> hashMap = new HashMap<>();
        //当我们往HashMap里放k1时，首先会调用Key这个类的hashCode方法计算它的hash值，随后把k1放入hash值所指引的内存位置。
        hashMap.put(k1,"v1");
        System.out.println(hashMap.get(k2));

        System.out.println(k1 == k1);

    }

    @Test
    public void integerTest(){
        Integer i1 = 128;
        Integer i2 = 128;
        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }

}
