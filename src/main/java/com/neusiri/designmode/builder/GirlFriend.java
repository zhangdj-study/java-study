package com.neusiri.designmode.builder;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * @author zhangdj
 * @date 2021/02/20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GirlFriend extends GirlFriendFather {
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

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bust=" + bust +
                ", waist=" + waist +
                ", hips=" + hips +
                ", hobby=" + hobby +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", gift=" + gift +
                "} " + super.toString();
    }
}
