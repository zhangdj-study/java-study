package com.neusiri.copyproperties;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangdj
 * @date 2019/11/20
 */
@Data
public class PersonVO {

    private Long id;

    private String name;

    private Date birth;

    private Integer age;
}
