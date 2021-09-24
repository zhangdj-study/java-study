package com.zdj.lambda.lambdademo1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangdj
 * @date 2019/8/1
 */
@Data
@AllArgsConstructor
public class Apple {

    private Long id;
    private String color;
    private Float weight;
    private String origin;
}
