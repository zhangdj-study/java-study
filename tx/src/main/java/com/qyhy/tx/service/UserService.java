package com.qyhy.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangdj
 * @date 2020/12/03
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void insertUser() {
        jdbcTemplate.update("insert into t_user(name,phone) values(?,?)", "na", "112");
        throw new RuntimeException();
    }
}
