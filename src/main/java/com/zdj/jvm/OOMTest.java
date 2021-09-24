package com.zdj.jvm;

import com.zdj.lambda.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zhangdj
 * @date 2021/02/04
 */
public class OOMTest {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(User.builder().userId(i++).userName(UUID.randomUUID().toString()).build());
            User.builder().userId(j--).build();
        }
    }

    @Test
    public void fillHeapTest() throws Exception {
        fillHeap();
        System.gc();
    }

    /**
     * JConsole监控
     */
    public void fillHeap() throws Exception {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }


    static class OOMObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }
}
