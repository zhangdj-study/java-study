package com.zdj.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangdj
 * @date 2019/7/31
 */
public class LambdaDemo2 {

    private static List<User> userList = new ArrayList<>();

    static {
        for (int i = 0; i < 5; i++) {
            User user = new User(i, "name" + i, "address" + i, "phone" + i);
            userList.add(user);
        }
    }

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

    /**
     * flatMap可以操作深层次的集合
     */
    @Test
    public void flatMap(){
        // 为每个User对象的bankCards赋值
        userList.forEach(a -> {
            List<String> bankCards = new ArrayList<>();
            bankCards.add("bk1");
            bankCards.add("bk2");
            a.setBankCards(bankCards);
        });
        // 操作每个User对象的每个bankCards
        userList.stream().flatMap(a -> a.getBankCards().stream()).forEach(b -> {
            b = b + "44";
            System.out.println(b);
        });
        System.out.println(userList);
    }


    @Test
    public void filterTest() {
        List<User> collect = userList.stream().filter(temp -> "qwe".equals(temp.getUserName())).limit(1).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void stream() {
        // 传入lambda表达式的变量必须是final或者有效final
        List<User> users = new ArrayList<>();
        Integer i = 3;
        i++;
        // 将i的值赋值给y 用y执行lambda表达式
        int y = i;
        userList = userList.stream().filter(temp -> temp.getUserId() > y).collect(Collectors.toList());
        userList.removeIf(temp -> temp.getUserId() == 3);
        userList.stream().filter(temp -> temp.getUserId() > 1).collect(Collectors.toList());

    }


}
