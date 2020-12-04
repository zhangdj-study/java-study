package com.qyhy.tx;

import com.qyhy.tx.configuration.SpringConfiguration;
import com.qyhy.tx.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangdj
 * @date 2020/11/26
 */
public class TxTest {

    @Test
    public void t1() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = ac.getBean(UserService.class);
        userService.insertUser();
    }
}
