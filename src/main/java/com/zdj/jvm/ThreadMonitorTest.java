package com.zdj.jvm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author zhangdj
 * @date 2021/05/31
 */
public class ThreadMonitorTest {

    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
             while (true){

             }
            }
        },"busyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "lockThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        createBusyThread();
        bufferedReader.readLine();
        Object o = new Object();
        createLockThread(o);
    }
 }
