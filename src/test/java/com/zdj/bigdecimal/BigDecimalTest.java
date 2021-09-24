package com.zdj.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author zhangdj
 * @date 2019/8/29
 */
public class BigDecimalTest {

    @Test
    public void test(){
        //保留两位小数
        DecimalFormat format = new DecimalFormat("0.00");
        //dividend
        BigDecimal bigDecimal = new BigDecimal("999999999999999999999999999999.000");
        BigDecimal bigDecimal2 = new BigDecimal("3.000");
        BigDecimal divide = bigDecimal.divide(bigDecimal2);
        BigDecimal bai = new BigDecimal(100);
        BigDecimal multiply = divide.multiply(bai);
        System.out.println(format.format(multiply));
    }
}
