package com.neusiri.io.stream.base;

import java.io.*;

/**
 * 将文件转换成字节数组
 * 将字节数组转换成文件
 *
 * @author zhangdj
 * @date 2019/9/16
 */
public class FileByteArrayTransformTest {
    public static void main(String[] args) {
        File file = new File("sources/2019.09.10.jpg");
        File dest = new File("sources/huoying.jpg");
        byte[] bytes = fileToByteArray(file);
        byteArrayToFile(bytes,dest);
    }

    /**
     * 将文件转换成为字节数组
     *
     * @param file 要转换的文件
     * @return 返回该文件的字节数组
     */
    public static byte[] fileToByteArray(File file) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024 * 1024];
            int len = inputStream.read(bytes, 0, bytes.length);
            System.out.println("read length " + len);
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将字节数组输出成文件
     * @param bytes 字节数组
     * @param dest 输出路径
     */
    public static void byteArrayToFile(byte[] bytes,File dest){
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(dest);
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
            System.out.println("write length " + bytes.length);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
