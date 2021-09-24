package com.zdj.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangdj
 */
@Data
public class StreamDemo {

    private  static List<User> userList = new ArrayList<User>();


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            User user = new User(i, "name" + i, "address" + i, "phone" + i);
            userList.add(user);
        }
        System.out.println(userList);
        List<String> stringList = userList.stream().map(a -> a.getUserName()).collect(Collectors.toList());
        System.out.println(stringList);

    }

}
