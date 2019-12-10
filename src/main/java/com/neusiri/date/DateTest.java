package com.neusiri.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangdj
 * @date 2019/10/26
 */
public class DateTest {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        String strDate = "2019-10-29";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = dateFormat.parse(strDate);
        String format = simpleDateFormat.format(parse);
        System.out.println(format);
    }

    @Test
    public void test() throws Exception {
        String s = "20191011";
        String time = "000000";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date parse = simpleDateFormat.parse(s + time);
        System.out.println(parse);
    }

    @Test
    public void test1() throws Exception {
        Boolean b = null;
        if (b) {
            System.out.println("a");
        } else {
            System.out.println("b");
        }
    }

    @Test
    public void test2() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = simpleDateFormat.format(new Date());
        Date parse = simpleDateFormat.parse(s);
        System.out.println(parse);
    }

    @Test
    public void test3() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String begins = "2019-11-18";
        Date begin = simpleDateFormat.parse(begins);
        String ends = "2019-11-30";
        Date end = simpleDateFormat.parse(ends);
        String s = simpleDateFormat.format(new Date());
        Date parse = simpleDateFormat.parse(s);
        System.out.println(parse);
        System.out.println(parse.after(begin) && parse.before(end));
    }

    @Test
    public void test4() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String begins = "2019-11-18";
        Date begin = simpleDateFormat.parse(begins);
        String ends = "2019-11-30";
        Date end = simpleDateFormat.parse(ends);
        String s = simpleDateFormat.format(new Date());
        Date parse = simpleDateFormat.parse(s);
        long current = parse.getTime();
        long beginTime = begin.getTime();
        long endTime = end.getTime();

        System.out.println(current > beginTime);
        System.out.println(current < endTime);
        System.out.println(current >= beginTime && current < endTime);
    }

}
