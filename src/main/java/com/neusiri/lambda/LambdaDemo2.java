package com.neusiri.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdj
 * @date 2019/7/31
 */
public class LambdaDemo2 {

    private  List<User> userList = new ArrayList<>();

    @Test
    public void threadTest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("old Thread");
            }
        }).start();


        new Thread(() -> System.out.println("MyThread....")).start();

    }

    @Test
    public void collectionTest(){
        for (int i = 0; i < 5; i++) {
            User user = new User(i, "name" + i, "address" + i, "phone" + i);
            userList.add(user);
        }
        userList.forEach(a -> System.out.println(a));
        System.out.println("-----");
        userList.forEach(System.out::println);
    }

    @Test
    public void mapTest(){
        for (int i = 0; i < 5; i++) {
            User user = new User(i, "name" + i, "address" + i, "phone" + i);
            userList.add(user);
        }
        //map 方法可以得到一个新的Stream 以下例子 将集合中的所有address作为一个新的Stream输出
        userList.stream().map(a -> a.getUserAddress()).forEach(a -> System.out.println(a));
    }

    @Test
    public void flatMap(){
        for (int i = 0; i < 5; i++) {
            User user = new User(i, "name" + i, "address" + i, "phone" + i);
            userList.add(user);
        }
        userList.stream().map(User::getUserAddress).flatMap(s -> userList.stream()).forEach(b -> System.out.println(b));
    }

}
