package com.zdj.io.stream.base;

import org.junit.Test;

import java.io.*;

/**
 * 字符在不同的编码集中 字节数不同
 *
 * @author zhangdj
 * @date 2019/9/7
 */
public class FileOperationTest {

    @Test
    public void read() {
        File file = new File("src/main/resources/456.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int r;
            while ((r = inputStream.read()) != -1) {
                System.out.println((char) r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void flushRead() {
        File file = new File("src/main/resources/456.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            //批量读取
            byte[] flush = new byte[1024];
            int len;
            while ((len = inputStream.read(flush)) != -1) {
                String s = new String(flush, 0, len);
                System.out.println("len " + len + "-->" + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void write() {
        File file = new File("src/main/resources/456.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            String s = "123\nqqq";
            byte[] bytes = s.getBytes();
            outputStream.write(bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件的拷贝
     */
    @Test
    public void copy() {
        //源文件
        File src = new File("2019.09.10.jpg");
        //目标文件
        File destination = new File("copy.jpg");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(destination);
            byte[] bytes = new byte[1024 * 20];
            int len;
            //将读取到的内容写入到新的文件中
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 在file对象下创建文件或者文件夹
     *
     * @throws IOException
     */
    @Test
    public void fileTest() throws IOException {
        File parentFile = new File("parent");
        parentFile.mkdirs();
        File file = new File(parentFile, "stream.txt");
        file.createNewFile();
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void reader() {
        File file = new File("sources/123.txt");
        Reader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[1024];
            int len;
            while ((len = reader.read(chars)) != -1) {
                String s = new String(chars, 0, len);
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void writer() {
        File file = new File("sources/123.txt");
        Writer writer = null;
        try {
            writer = new FileWriter(file, true);
            String s = "阿萨德";
            writer.append(s).append("我不就").append("qwe");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void byteArrayInputStream() {
        byte[] src = "talk is cheap show me the code".getBytes();
        InputStream inputStream = null;
        try {
            //不需要关闭 gc会进行回收
            inputStream = new ByteArrayInputStream(src);
            byte[] flush = new byte[5];
            while ((inputStream.read(flush)) != -1){
                String s = new String(flush,0,flush.length);
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void byteArrayOutputStream(){
        String s = "talk is cheap show me the code";
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] src = s.getBytes();
            //写
            byteArrayOutputStream.write(src,0,src.length);
            //获取数据
            byte[] bytes = byteArrayOutputStream.toByteArray();
            String out = new String(bytes,0,bytes.length);
            System.out.println(out);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
