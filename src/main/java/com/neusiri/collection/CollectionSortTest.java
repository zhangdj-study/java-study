package com.neusiri.collection;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * @author zhangdj
 * @date 2021/07/19
 */
public class CollectionSortTest {

    @Test
    public void t1() throws Exception {
        ArrayList<Date> list = new ArrayList<>();
        Date d1 = DateUtils.parseDate("2021-04-19 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date d2 = DateUtils.parseDate("2021-06-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date d3 = DateUtils.parseDate("2021-06-19 00:00:00", "yyyy-MM-dd HH:mm:ss");
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.sort((a1, a2) -> {
            System.out.println(a1.getTime());
            System.out.println(a2.getTime());
            System.out.println("int value " + (int) (a1.getTime() - a2.getTime()));
            System.out.println("long value " + (a1.getTime() - a2.getTime()));
            return (int) (a1.getTime() - a2.getTime());
        });
        System.out.println(list);

        System.out.println("---------------");

    }
}
