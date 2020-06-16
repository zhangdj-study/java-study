package com.neusiri.collection;

import org.junit.Test;

import java.util.*;

/**
 * 集合测试
 * @author zhangdj
 * @date 2019/11/11
 */
public class Main {

    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        for (String s : list){
            System.out.println("!");
        }
    }

    /**
     *向 Set集合加入元素，成功返回true，失败返回false
     */
    @Test
    public void setTest(){
        Set<String> stringSet = new HashSet<>();
        boolean add = stringSet.add("1");
        System.out.println(add);
        boolean add2 = stringSet.add("1");
        System.out.println(add2);
    }

    @Test
    public void merge(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("1.1");
        list1.add("1.2");
        list2.add("2.1");
        list2.add("2.2");
        list1.addAll(list2);
        System.out.println("list1-----" + list1);
        System.out.println("list2-----" + list2);

    }

    @Test
    public void mapTest(){
        HashMap map = new HashMap(10);
        map.put(null,"v1");
        map.put("k1",null);
        System.out.println(map);
        System.out.println(map.get(null));
        System.out.println(map.get("k1"));
        Hashtable hashtable = new Hashtable();
        hashtable.put("1","v3");
        System.out.println(hashtable);
    }


}
