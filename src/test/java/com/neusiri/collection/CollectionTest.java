package com.neusiri.collection;


import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangdj
 * @date 2019/8/27
 */
public class CollectionTest {

    @Test
    public void test1(){
        Set set = new HashSet();

        System.out.println(set);
        List list = new ArrayList<>();
        list.add(1);
        list.add(1);
        System.out.println(list);

        CollectionUtils.addAll(list,set);
        System.out.println(set);


    }
}
