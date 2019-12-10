package com.neusiri.io.stream.base.splitfile;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author zhangdj
 * @date 2019/10/8
 */
@Data
public class SplitFile {

    /**
     * 源文件路径
     */
    private File src;

    /**
     * 源文件大小
     */
    private long srcSize;

    /**
     * 目标文件夹
     */
    private String dest;

    /**
     * 每块大小
     */
    private int blockSize;

    /**
     * 块数
     */
    private int blockNum;

    /**
     * 文件扩展名
     */
    private String extName;

    /**
     * 文件分割后的存储路径
     */
    private List<String> destPaths;

    /**
     * 构造方法
     * @param srcPath 源文件路径
     * @param dest 分割文件存储的位置
     * @param blockSize 分割文件每块大小
     * @throws Exception
     */
    public SplitFile(String srcPath, String dest, int blockSize) throws Exception {
        this.src = new File(srcPath);
        this.dest = dest;
        this.blockSize = blockSize;
        init();
        split();
    }

    /**
     * 初始化源文件大小并计算块数
     */
    private void init() {
        //源文件大小
        this.srcSize = this.src.length();
        //块数
        this.blockNum = (int) Math.ceil(srcSize * 1.0 / this.blockSize);
        //扩展名
        String srcName = src.getName();
        int index = srcName.lastIndexOf(".");
        this.extName = srcName.substring(index);
        //分割文件路径
        this.destPaths = new ArrayList<>();
        for (int i = 0; i < blockNum; i++) {
            destPaths.add(dest + "/" + i + "-" + src.getName());
        }
    }

    /**
     * 分割文件
     *
     * @throws Exception
     */
    private void split() throws Exception {
        //开始位置
        long beginPos = 0;
        //每次读取的实际长度(如果文件大小比每块大小还小，取文件的大小，否则取每块大小)
        long len = (blockSize > srcSize ? srcSize : blockSize);
        for (int i = 0; i < blockNum; i++) {
            //开始位置随着分割会改变
            beginPos = i * this.blockSize;
            if (i != blockNum - 1) {
                len = blockSize;
                srcSize -= len;
            } else {
                len = srcSize;
            }
            splitFile(i, beginPos, len);
        }
    }

    /**
     * 文件分割方法(读取文件时，取较小的长度)
     *
     * @param i        块数
     * @param beginPos 起始位置
     * @param len      读取长度
     * @throws Exception 异常
     */
    private void splitFile(int i, long beginPos, long len) throws Exception {
        //获取切割后的文件名
        String splitFileName = destPaths.get(i);
        RandomAccessFile reader = new RandomAccessFile(src, "r");
        RandomAccessFile writer = new RandomAccessFile(splitFileName, "rw");
        reader.seek(beginPos);
        byte[] flush = new byte[1024];
        int actualSize;
        while ((actualSize = reader.read(flush)) != -1) {
            //想要读取的长度 比实际读取的长度大 取实际长度
            if (len >= actualSize) {
                writer.write(flush, 0, actualSize);
                //想要读取的长度减去已经读取的长度
                len -= actualSize;
            } else {
                //想要读取的长度 比实际读取长度小  取想要的长度
                writer.write(flush, 0, (int) len);
                break;
            }
        }
        reader.close();
        writer.close();
    }

    /**
     * 合并文件
     * 可以用SequenceInputStream将多个输入流进行合并 也可以分别操作输入流
     * @param mergeDest 合并文件存放的位置
     * @throws Exception
     */
    private void merge(String mergeDest) throws Exception {
        //输出流
        OutputStream outputStream = new FileOutputStream(mergeDest + "/merge" + extName, true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        Vector<InputStream> vector = new Vector<>();
        SequenceInputStream sequenceInputStream = null;
        //遍历切割文件
        for (String path : destPaths) {
            InputStream inputStream = new FileInputStream(path);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            //将输入流放入容器
            vector.add(bufferedInputStream);
        }
        //实例化SequenceInputStream
        sequenceInputStream = new SequenceInputStream(vector.elements());
        byte[] flush = new byte[1024];
        int actualSize;
        //读取文件内容并且追加写入新的文件
        while ((actualSize = sequenceInputStream.read(flush)) != -1) {
            bufferedOutputStream.write(flush, 0, actualSize);
        }
        bufferedOutputStream.flush();
        sequenceInputStream.close();
        bufferedOutputStream.close();
    }

    /**
     * 测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String srcPath = "src/main/resources/123.txt";
        String destPath = "src/main/resources/dest";
        int blockSize = 10;
        SplitFile splitFile = new SplitFile(srcPath, destPath, blockSize);
        splitFile.merge("src/main/resources/mergedest");
        System.out.println(splitFile);
    }
}
