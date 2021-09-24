package com.zdj.collection;

import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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


    /**
     * 集合中数据分组
     */
    @Test
    public void getCommonPropertiesList() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(12, "Bob"));
        list.add(new Person(12, "John"));
        list.add(new Person(13, "Marry"));

        Map<Integer, List<Person>> collect = list.stream().collect(Collectors.groupingBy(Person::getAge));

        System.out.println(collect);
    }


    @Data
    class Person {
        private Integer age;

        private String name;

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
