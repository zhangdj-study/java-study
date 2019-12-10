package com.neusiri.io.stream.base;

import org.junit.Test;

import java.io.File;

/**
 * 查看用户当前目录
 * @author zhangdj
 * @date 2019/8/22
 */
public class QueryDirTest {

    @Test
    public void getUsrDir(){
        System.out.println(System.getProperty("user.dir"));

        //使用相对路径的时候 会自动拼接userDir
        File file = new File("sources/huoying.jpg");
        System.out.println(file.getAbsolutePath());
    }
}
