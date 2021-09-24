package com.zdj.io.stream.base;

import java.io.*;

/**
 * @author zhangdj
 * @date 2019/9/16
 */
public class FileUtil {

    public static void copyFile(File srcFile, File destFile){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        if (srcFile.exists()){
            byte[] bytes = new byte[1024];
            int len;
            try{
                inputStream = new FileInputStream(srcFile);
                outputStream = new FileOutputStream(destFile);
                while ((len = inputStream.read(bytes)) != -1){
                    outputStream.write(bytes,0,len);
                    outputStream.flush();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                close(inputStream,outputStream);
            }
        }else {
            return;
        }
    }

    /**
     * 只要实现了Closeable接口 就可以作为入参传入该方法 可以传入多个参数 进行流的关闭操作
     * @param closeables
     */
    public static void close(Closeable... closeables){
        for (Closeable closeable :closeables) {
            if (null != closeable){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
