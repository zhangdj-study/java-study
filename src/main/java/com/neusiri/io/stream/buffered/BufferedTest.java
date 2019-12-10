package com.neusiri.io.stream.buffered;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author zhangdj
 * @date 2019/9/23
 */
public class BufferedTest {

    /**
     * 缓冲字符流 复制文件
     */
    @Test
    public void bufferedReaderWriterTest(){
        String path = "sources/123.txt";
        String dest = "sources/123-copy.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest))
        ) {
            String readContent = "";
            while ((readContent = bufferedReader.readLine()) != null){
                bufferedWriter.write(readContent,0,readContent.length());
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
