package com.zdj.equals.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author zhangdj
 * @date 2019/8/9
 */
@Data
@AllArgsConstructor
public class Contract {

    private Integer id;

    private String goodsName;

    private Date contractBeginTime;

    private Date contractEndTime;

    public boolean equals(Order order){
        if (order.getGoodsName().equals(this.getGoodsName())){
            return true;
        }
        return false;
    }

}
