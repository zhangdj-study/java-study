package com.zdj.io.stream.base.objectstream;

import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * 对象流
 * 1、写出后读取
 * 2、读取的顺序应和写出的顺序一致
 * 3、被操作的对象需要实现Serializable接口
 *
 * @author zhangdj
 * @date 2019/9/25
 */
public class ObjectStreamTest {

    @Test
    public void test() throws Exception{
        //写出 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        objectOutputStream.writeObject(new Date());
        objectOutputStream.writeObject("某某某");
        objectOutputStream.writeObject(new User(1L, "username", "password"));
        objectOutputStream.flush();

        byte[] bytes = byteArrayOutputStream.toByteArray();
        //读取 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
        Object dateObject = objectInputStream.readObject();
        Object strObject = objectInputStream.readObject();
        Object userObject = objectInputStream.readObject();
        if (dateObject instanceof Date){
            Date date = (Date) dateObject;
            System.out.println(date);
        }
        if (strObject instanceof String){
            String string = (String) strObject;
            System.out.println(string);
        }
        if (userObject instanceof User){
            User user = (User) userObject;
            System.out.println(user);
        }
        close(bufferedOutputStream,objectOutputStream,bufferedInputStream,objectInputStream);
    }

    @Test
    public void test2() throws Exception{
        //写出 序列化
        OutputStream outputStream = new FileOutputStream("src/main/resources/object-test.ins");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        objectOutputStream.writeObject(new Date());
        objectOutputStream.writeObject("某某某");
        objectOutputStream.writeObject(new User(1L, "username", "password"));
        objectOutputStream.flush();

        //读取 反序列化
        InputStream inputStream = new FileInputStream("src/main/resources/object-test.ins");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
        Object dateObject = objectInputStream.readObject();
        Object strObject = objectInputStream.readObject();
        Object userObject = objectInputStream.readObject();
        if (dateObject instanceof Date){
            Date date = (Date) dateObject;
            System.out.println(date);
        }
        if (strObject instanceof String){
            String string = (String) strObject;
            System.out.println(string);
        }
        if (userObject instanceof User){
            User user = (User) userObject;
            System.out.println(user);
        }
        close(bufferedOutputStream,objectOutputStream,bufferedInputStream,objectInputStream);
    }


    /**
     * 只要实现了Closeable接口 就可以作为入参传入该方法 可以传入多个参数 进行流的关闭操作
     * @param closeables 实现了Closeable接口的需要关闭的流
     */
    private void close(Closeable... closeables){
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
