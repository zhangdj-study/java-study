package com.neusiri.designmode.builder;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author zhangdj
 * @date 2021/02/20
 */
@Data
public class GirlFriend {
    private String name;

    private int age;

    private int bust;

    private int waist;

    private int hips;

    private List<String> hobby;

    private String birthday;

    private String address;

    private String mobile;

    private String email;

    private String hairColor;

    private Map<String, String> gift;
}
