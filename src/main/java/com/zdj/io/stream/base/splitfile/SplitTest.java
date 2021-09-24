package com.zdj.io.stream.base.splitfile;

import org.junit.Test;

import java.io.*;

/**
 * @author zhangdj
 * @date 2019/9/25
 */
public class SplitTest {

    @Test
    public void test() throws Exception {
        //Instances of this class support both reading and writing to a random access file
        RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/123.txt", "r");
        //从第3个字节开始读取文件
        randomAccessFile.seek(3);
        byte[] flush = new byte[1024];
        int len;
        while ((len = randomAccessFile.read(flush)) != -1) {
            String s = new String(flush, 0, len);
            System.out.println(s);
        }
        randomAccessFile.close();
    }

    /**
     * 分段读取文件内容
     *
     * @throws Exception 异常
     */
    @Test
    public void test1() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/123.txt", "r");
        //开始位置
        int startPos = 2 + 6;
        randomAccessFile.seek(startPos);
        //想要读取的长度
        int wantLen = 6;
        byte[] flush = new byte[1024];

        int actualLen;
        while ((actualLen = randomAccessFile.read(flush)) != -1) {
            //想要读取的长度 比实际读取的长度大 全部取出
            if (wantLen >= actualLen) {
                String s = new String(flush, 0, actualLen);
                System.out.println(s);
                //想要读取的长度减去已经读取的长度
                wantLen -= actualLen;
            } else {
                String s = new String(flush, 0, wantLen);
                System.out.println(s);
                break;
            }
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        //开始位置
        long beginPos = 0;
        //每块大小
        long blockSize = 1024 * 2;
        //源文件
        File file = new File("src/main/resources/2019.09.10.jpg");
        //目标文件夹
        String dest = "src/main/resources/dest";
        //源文件大小 会随着读取次数的增加而减小
        long size = file.length();
        //块数
        int blockNum = (int) Math.ceil(size * 1.0 / blockSize);
        System.out.println("块数为：" + blockNum);
        //每次读取的实际长度(应该是每块大小，如果文件大小比每块大小还要小，取文件的大小，否则取每块大小)
        long wantLen = (blockSize > size ? size : blockSize);
        //读取
        for (int i = 0; i < blockNum; i++) {
            //每次读取 起始位置要发生变化
            beginPos = i * blockSize;
            //如果不是最后一块
            if (i != blockNum - 1) {
                wantLen = blockSize;
                size -= blockSize;
            } else {//最后一块 实际读取的大小是剩下的文件大小
                wantLen = size;
            }
            System.out.println(i + "-->" + beginPos + "-->" + wantLen);
            splitFile(i, beginPos, wantLen);
        }
    }


    /**
     * 文件分割方法(读取文件时，取较小的长度)
     *
     * @param beginPos 起始位置
     * @param wantLen  读取长度
     * @throws Exception 异常
     */
    public void splitFile(int i, long beginPos, long wantLen) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/2019.09.10.jpg", "r");
        RandomAccessFile writer = new RandomAccessFile("src/main/resources/dest/" + i + ".jpg", "rw");
        randomAccessFile.seek(beginPos);
        byte[] flush = new byte[1024];
        int actualSize;
        while ((actualSize = randomAccessFile.read(flush)) != -1) {
            //想要读取的长度 比实际读取的长度大 取实际长度
            if (wantLen >= actualSize) {
                String s = new String(flush, 0, actualSize);
//                System.out.println(s);
                writer.write(flush, 0, actualSize);
                //想要读取的长度减去已经读取的长度
                wantLen -= actualSize;
            } else {
                //想要读取的长度 比实际读取长度小  取想要的长度
                String s = new String(flush, 0, (int) wantLen);
//                System.out.println(s);
                writer.write(flush, 0, (int) wantLen);
                break;
            }
        }
        randomAccessFile.close();
    }
}
