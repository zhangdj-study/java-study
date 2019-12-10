package com.neusiri.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
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
}
