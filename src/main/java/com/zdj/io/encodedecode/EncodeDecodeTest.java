package com.zdj.io.encodedecode;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * 编码 解码
 * 乱码问题
 * @author zhangdj
 * @date 2019/9/7
 */
public class EncodeDecodeTest {


    @Test
    public void encode(){
        String s = "哈哈哈h";
        //编码 默认使用工程的编码方式
        byte[] bytes = s.getBytes();
        //UTF8 中文三个字节 英文一个字节（变长）
        System.out.println(bytes.length);

        String s1 = new String(s.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        System.out.println(s1);
    }

    @Test
    public void encode1(){
        String s = "哈哈哈h";
        //编码 默认使用工程的编码方式
        byte[] bytes = s.getBytes();
        //UTF8 中文三个字节 英文一个字节（变长）
        System.out.println(bytes.length);

        String s1 = new String(s.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        String s2 = new String(s1.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void decode() throws UnsupportedEncodingException {
        String s = "哈哈哈h";
        //编码 默认使用工程的编码方式UTF-8
        byte[] bytes = s.getBytes();
        //使用相同字符集 可以正常打印
        s = new String(bytes,0,bytes.length, StandardCharsets.UTF_8);
        System.out.println(s);
        //字节数不够 出现乱码
        s = new String(bytes,0,5,StandardCharsets.UTF_8);
        System.out.println(s);
        //字符集不统一 出现乱码
        s = new String(bytes,0,bytes.length-2,"gbk");
        System.out.println(s);
    }
}
