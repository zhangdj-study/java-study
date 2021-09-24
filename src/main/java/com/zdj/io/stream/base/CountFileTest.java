package com.zdj.io.stream.base;

import org.junit.Test;

/**
 * @author zhangdj
 * @date 2019/8/23
 */
public class CountFileTest {

    @Test
    public void fileCountTest(){
        CountFile countFile = new CountFile("C:/Users/neusoft/Desktop/111");
        System.out.println(countFile.getSize());
        System.out.println("getDirectoryNum:"+countFile.getDirectoryNum());
        System.out.println("getFileNum:"+countFile.getFileNum());
    }
}
