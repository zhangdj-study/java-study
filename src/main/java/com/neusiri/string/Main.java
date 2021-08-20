package com.neusiri.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangdj
 * @date 2020-06-04 19:28
 */
public class Main {

    @Test
    public void stringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1");
    }

    @Test
    public void array() {
        int[] arr = new int[]{2, 3, 4};
        arr[1] = 2;
        System.out.println(arr.length);
    }

    @Test
    public void subStringTest() {
        String fileUrl = "http://10.1.252.60/group1/M00/00/00/CgH8PF8n9HiAcn3rAAD_NbOj3to210.Jpg";
        String fileUrlWithoutIp = fileUrl.substring(fileUrl.indexOf("/g") + 1);
        String path = fileUrl.substring(fileUrl.indexOf("/") + 1);
    }

    @Test
    public void split() {
        String a = "1,2";
        String b = "1";
        System.out.println(Arrays.toString(a.split(",")));
        System.out.println(Arrays.toString(b.split(",")));
    }

}
