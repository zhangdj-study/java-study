package com.neusiri.equals.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author zhangdj
 * @date 2019/8/9
 */
@Data
@AllArgsConstructor
public class Order {

    private Integer id;

    private String goodsName;

    private Date contractBeginTime;

    public boolean equals(Contract contract) {
        if (contract.getGoodsName().equals(this.getGoodsName())) {
            return true;
        } else {
            return false;
        }
    }
}
