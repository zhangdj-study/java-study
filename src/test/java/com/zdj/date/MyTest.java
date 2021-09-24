package com.zdj.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangdj
 * @date 2019/10/21
 */
public class MyTest {

    @Test
    public void test() throws Exception{
        String format = "yyyy-MM-hh HH:mm:ss";
        Date nowTime = new Date();
        Date startTime = new SimpleDateFormat(format).parse("2019-10-20 09:00:00");
        Date endTime = new SimpleDateFormat(format).parse("2019-10-22 09:00:00");
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
