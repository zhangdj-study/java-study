package com.zdj.decode;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author zhangdj
 * @date 2019/9/17
 */
public class DecodeTest {

    @Test
    public void decode(){
        String decode = null;
        try {
            decode = URLDecoder.decode("%E5%93%88%E5%93%88%E5%93%88%5C%E7%9C%8B%E7%9C%8B%5C%E6%9D%A5%E4%BA%86","UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(decode);
    }
}
