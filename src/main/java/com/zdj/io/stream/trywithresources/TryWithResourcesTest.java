package com.zdj.io.stream.trywithresources;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Try-With-Resources 可以自动关闭资源
 *
 * @author zhangdj
 * @date 2019/9/18
 */
public class TryWithResourcesTest {

    @Test
    public void test() {
        String path = "";
        try (InputStream inputStream = new FileInputStream(path)) {
            inputStream.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try (SystemResource systemResource = new SystemResource(); HardDisResource hardDisResource = new HardDisResource()) {

        } catch (Exception e) {

        }
    }

    @Test
    public void test3() {
        SystemResource systemResource = new SystemResource();
        HardDisResource hardDisResource = new HardDisResource();
        try {

        } catch (Exception e) {

        } finally {
            try {
                if (systemResource != null) {
                    systemResource.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (hardDisResource != null) {
                    hardDisResource.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void test4() {
        try (SystemResource systemResource = new SystemResource()) {

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
