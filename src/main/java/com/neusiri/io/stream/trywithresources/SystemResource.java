package com.neusiri.io.stream.trywithresources;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author zhangdj
 * @date 2019/9/18
 */
public class SystemResource implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("SystemResources have closed");
    }
}
