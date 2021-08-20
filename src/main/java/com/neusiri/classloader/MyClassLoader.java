package com.neusiri.classloader;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @author zhangdj
 * @date 2021/08/09
 * 自定义类加载器
 */
public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    public MyClassLoader() {}

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();

        // 字节流解密
//        data = DESInstance.deCode("1234567890qwertyuiopasdf".getBytes(), data);

        return data;
    }


    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:\\Program Files\\JetBrains\\workspace\\java-study\\target\\classes\\com\\neusiri\\abstrac");
        Class clazz = myClassLoader.loadClass("com.neusiri.abstrac.Main");
        Object o = clazz.newInstance();
        Method print = clazz.getDeclaredMethod("print", null);
        print.invoke(o, null);
    }
}
