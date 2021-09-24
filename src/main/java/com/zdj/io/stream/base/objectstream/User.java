package com.zdj.io.stream.base.objectstream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangdj
 * @date 2019/9/25
 */
@Data
@AllArgsConstructor
public class User implements Serializable {

    private Long id;

    private String username;

    /**
     * transient 表明该属性不参与序列化
     */
    private transient String password;
}
