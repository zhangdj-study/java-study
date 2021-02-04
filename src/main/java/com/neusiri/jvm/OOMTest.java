package com.neusiri.jvm;

import com.neusiri.lambda.User;

import java.time.Year;
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
        while (true) {
            User user = new User();
            user.setUserAddress(UUID.randomUUID().toString());
            list.add(user);
        }
    }
}
