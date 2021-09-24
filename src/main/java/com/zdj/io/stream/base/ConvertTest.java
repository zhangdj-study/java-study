package com.zdj.io.stream.base;

import org.junit.Test;

import java.io.*;
import java.net.URL;

/**
 * 转换流
 * InputStreamReader 字节流->字符流
 * OutPutStreamWriter 字符流->字节流
 *
 * @author zhangdj
 * @date 2019/9/23
 */
public class ConvertTest {

    /**
     * 键盘在console输入字符 并打印在控制台
     */
    @Test
    public void test() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String inputString = "";
            while (!"exit".equals(inputString)) {
                String readString = reader.readLine();
                writer.write(readString);
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载百度源码
     */
    @Test
    public void test2() {
        //字符集要统一
        try(InputStream inputStream = new URL("https://www.baidu.com").openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            int len;
/*            while ((len = inputStreamReader.read()) != -1){
                System.out.print((char) len);
            }*/
           String s = "";
/*           while ((s = bufferedReader.readLine()) != null){
               System.out.println(s);
               System.out.println("------");
           }*/
           while (bufferedReader.readLine() != null){
               System.out.println(bufferedReader.readLine());
               System.out.println("----");
           }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 下载百度页面的源码并输出为html
     */
    @Test
    public void test3() {
        //字符集要统一
        try(InputStream inputStream = new URL("https://www.baidu.com").openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            OutputStream outputStream = new FileOutputStream("src/main/resources/baidu.html");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)
            ) {
            String s = "";
            while ((s = bufferedReader.readLine()) != null){
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 键盘输入测试
     * idea 单元测试控制台不能输入问题解决
     * 在 idea bin目录下的idea64.exe.vmoptions文件 加入 -Deditable.java.test.console=true
     */
    @Test
    public void keywordInput() {
        InputStream inputStream = System.in;
        try {
            byte[] bytes = new byte[10];
            int len;
            while ((len = inputStream.read(bytes, 0, bytes.length)) != -1) {
                System.out.println(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void keywordInput2() {
        InputStream inputStream = System.in;
        try {
            int read = inputStream.read();
            System.out.println((char) read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
