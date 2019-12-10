package com.neusiri.io.stream.buffered;

import org.junit.Test;

import java.io.*;

/**
 * 分别用缓冲流 和 节点流 复制文件 并对比效率
 * @author zhangdj
 * @date 2019/9/18
 */
public class BufferedNodeTest {

    /**
     * 缓冲流复制文件测试
     */
    @Test
    public void bufferedStreamCopyTest(){
        String path = "sources/bigFile/starumlpjbd.zip";
        String dest = "sources/bigFile/starumlpjbd-copy.zip";
        long start = System.currentTimeMillis();
        copyBuffered(path,dest);
        long end = System.currentTimeMillis();
        long costTime = end - start;
        System.out.println("BufferedStream copy stream cost time is " + costTime);
    }

    /**
     * 节点流复制文件测试
     */
    @Test
    public void nodeStreamCopyTest(){
        String path = "sources/bigFile/starumlpjbd.zip";
        String dest = "sources/bigFile/starumlpjbd-copy.zip";
        long start = System.currentTimeMillis();
        copy(path,dest);
        long end = System.currentTimeMillis();
        long costTime = end - start;
        System.out.println("NodeStream copy stream cost time is " + costTime);
    }

    /**
     * 缓冲流复制文件
     * @param path
     * @param dest
     */
    public void copyBuffered(String path,String dest){
        try(InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 节点流复制文件
     * @param path
     * @param dest
     */
    public void copy(String path,String dest){
        try(InputStream inputStream = new FileInputStream(path);
            OutputStream outputStream = new FileOutputStream(dest)) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
