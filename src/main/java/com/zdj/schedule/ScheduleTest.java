package com.zdj.schedule;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author zhangdj
 * @date 2021/09/23
 */
public class ScheduleTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 3000, 3000);
    }

    @Test
    public void t1() {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 0, 3000);
    }


    static class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("123");
        }
    }
}
