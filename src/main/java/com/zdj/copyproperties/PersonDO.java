package com.zdj.copyproperties;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author zhangdj
 * @date 2019/11/20
 */
@Data
@AllArgsConstructor
public class PersonDO {

    private Long id;

    private String name;

    private Date birth;

    private Integer age;
}
