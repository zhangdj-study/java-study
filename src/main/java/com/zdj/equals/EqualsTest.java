package com.zdj.equals;

import com.zdj.equals.model.Contract;
import com.zdj.equals.model.Order;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangdj
 * @date 2019/8/5
 */
public class EqualsTest {

    /**
     * 括号
     */
    @Test
    public void bracketTest() {
        String abc1 = "百度科技(123（））)公司1";
        abc1 = abc1.replaceAll("\\(|\\)", "").replaceAll("（","").replaceAll("）","");
        System.out.println(abc1);

    }

    /**
     * 判断list中是否有这个字符串
     */
    @Test
    public void listContainsStringTest(){
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();


        list.add("a)");
        list.add("b（");
        list.add("c");
//        System.out.println(list.contains("a"));
//        System.out.println(list.contains("d"));
        for (String s: list) {
            String s1 = s.replaceAll("\\(|\\)", "").replaceAll("（", "").replaceAll("）", "");
            list2.add(s1);
        }
        System.out.println(list2);
    }

    @Test
    public void listContainsTest(){
        List<Contract> list = new ArrayList<>();
        Contract contract1 = new Contract(1, "杯子", new Date(), new Date());
        list.add(contract1);
        Contract contract2 = new Contract(2, "空调", new Date(), new Date());
        list.add(contract2);
        Order order = new Order(1,"杯子",new Date());
//        for (Contract c :list) {
//            if (c.equals(order)){
//                System.out.println(111);
//                System.out.println(c);
//            }
//        }
        list.stream().forEach(a -> {
            if (a.equals(order)){
                System.out.println(a);
            }

        });
    }

    @Test
    public void differentModelEqualsTest(){
        Contract contract1 = new Contract(1, "杯子", new Date(), new Date());
        Order order = new Order(1,"杯子",new Date());
        System.out.println(contract1.equals(order));
    }

    @Test
    public void overrideEquals(){
        Contract contract1 = new Contract(1, "杯子", new Date(), new Date());
        Contract contract2 = new Contract(2, "空调", new Date(), new Date());
        Contract contract3 = new Contract(3,"杯子",new Date(),new Date());
        System.out.println(contract1.equals(contract2));
        System.out.println(contract1.equals(contract3));
    }


    @Test
    public void dateIsEquals() throws Exception{
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date1.equals(date2));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse("1999-11-11 11:11:11");
        System.out.println(parse);
        System.out.println(parse.equals(date1));
    }

}
