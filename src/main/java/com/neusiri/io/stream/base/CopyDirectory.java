package com.neusiri.io.stream.base;

import java.io.*;

/**
 * 拷贝文件夹的内容
 *
 * @author zhangdj
 * @date 2019/9/10
 */
public class CopyDirectory {


    public static void main(String[] args) {
        File srcFile = new File("sources/789");
        File destinationFile = new File("sources/finalCopy");
        copy(srcFile,destinationFile);
    }

    public static void copy(File srcFile, File destinationFile) {
        try {
            if (!destinationFile.exists()){
                destinationFile.mkdirs();
            }
            if (srcFile.isDirectory()){
                copyDirectory(srcFile,destinationFile);
            }else {
                File file = new File(destinationFile,srcFile.getName());
                copyFile(srcFile,file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 复制文件
     * @param srcFile 源文件
     * @param destFile 目标文件夹
     */
    public static void copyFile(File srcFile,File destFile){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        if (srcFile.exists()){
            byte[] bytes = new byte[1024];
            int len;
            try {
                inputStream = new FileInputStream(srcFile);
                outputStream = new FileOutputStream(destFile);
                while ((len = inputStream.read(bytes)) != -1){
                    outputStream.write(bytes,0,len);
                    outputStream.flush();
                }
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
                if (null != inputStream){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            return;
        }
    }

    /**
     * 复制文件夹
     * @param srcFile 源文件夹
     * @param destFile 目标文件夹
     */
    public static void copyDirectory(File srcFile,File destFile){
        //源文件夹存在
        if (srcFile.exists()){
            //或者源文件夹下的文件或文件夹
            File[] files = srcFile.listFiles();
            //目标文件夹不存在 则创建文件夹
            if (!destFile.exists()){
                destFile.mkdirs();
            }
            //遍历源文件下的文件或文件夹
            for (File file: files) {
                //如果是目录
                if (file.isDirectory()){
                    //递归创建文件夹
                    copyDirectory(file,new File(destFile,file.getName()));
                }else {
                    ///如果是文件 则复制文件（在目标文件下）
                    copyFile(file,new File(destFile,file.getName()));
                }
            }
        }else {
            return;
        }
    }


}
