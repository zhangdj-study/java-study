package com.neusiri.io.stream.base;

import lombok.Data;

import java.io.File;

/**
 * 统计文件或文件夹的大小
 *
 * @author zhangdj
 * @date 2019/8/23
 */
@Data
public class CountFile {

    private long size;

    private File file;

    private String path;

    private long fileNum;

    private long directoryNum;

    public CountFile(String path) {
        this.path = path;
        this.file = new File(path);
        count(this.file);
    }

    public void count(File file) {
        if (null != file && file.exists()){
            //如果file是文件
            if (file.isFile()){
                this.fileNum++;
                this.size += file.length();
            }else {
                this.directoryNum++;
                for(File f : file.listFiles()){
                    count(f);
                }
            }
        }
    }
}
