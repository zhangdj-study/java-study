package com.neusiri.string;

import org.junit.Test;

/**
 * @author zhangdj
 * @date 2020-06-04 19:28
 */
public class Main {

    @Test
    public void stringBuffer(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1");
    }

    @Test
    public void array() {
        int[] arr = new int[]{2,3,4};
        arr[1] = 2;
        System.out.println(arr.length);
    }

}
