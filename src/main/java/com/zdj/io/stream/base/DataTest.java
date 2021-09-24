package com.zdj.io.stream.base;

import org.junit.Test;

import java.io.*;

/**
 * 数据流
 * 1、写出后读取
 * 2、读取的顺序应和写出的顺序一致
 * @author zhangdj
 * @date 2019/9/24
 */
public class DataTest {

    /**
     * 数据流 处理基本数据类型和String类型 使用字节数组存储数据
     * @throws Exception
     */
    @Test
    public void test() throws Exception{
        //向字节数组流写出数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF("类型");
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeChar('a');
        dataOutputStream.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        //读取 要按写入的顺序读取
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        String s = dataInputStream.readUTF();
        boolean b = dataInputStream.readBoolean();
        char c = dataInputStream.readChar();
        System.out.println(s);
        System.out.println(b);
        System.out.println(c);
    }

    /**
     * 数据流 处理基本数据类型和String类型 使用文件存储数据
     * DataOutputStream向文件写入时会做特殊的标记，只有DataInputStream才能进行读取
     * 除了包含信息本身之外，还有类型标识等，只有使用DataInputStream才能正确读取原有信息，其他方式会产生乱码
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        //向文件写出数据
        try(OutputStream outputStream = new FileOutputStream("src/main/resources/data.txt");
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            InputStream inputStream = new FileInputStream("src/main/resources/data.txt");
            DataInputStream dataInputStream = new DataInputStream(inputStream)) {

            dataOutputStream.writeUTF("类型");
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeChar('a');
            dataOutputStream.flush();
            //读取文件中的数据 要按写入的顺序读取
            String s = dataInputStream.readUTF();
            boolean b = dataInputStream.readBoolean();
            char c = dataInputStream.readChar();
            System.out.println(s);
            System.out.println(b);
            System.out.println(c);
        }
    }
}
