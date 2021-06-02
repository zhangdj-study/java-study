package com.neusiri.socket;

import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangdj
 * @date 2021/05/31
 */
public class SocketTest {

    @Test
    public void client() {
        try {
            Socket s = new Socket();
            s.setSoLinger(true, 0);
            s.connect(new InetSocketAddress("127.0.0.1",3113));

            OutputStream os = s.getOutputStream();
            os.write("client send hello".getBytes());

            s.close();
            // 防止程序退出
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void server() {
        try {
            ServerSocket ss = new ServerSocket(3113);
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            byte[] buf =new byte[1024];
            int len = is.read(buf);
            System.out.println("recv:"+new String(buf,0,len));

            Thread.sleep(10000);

            s.getOutputStream().write("hello".getBytes());

            System.out.println("send over");
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
