package com.qyhy.tx.configuration;

import com.qyhy.tx.utils.JdbcUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author zhangdj
 * @date 2020/12/03
 *
 * @EnableTransactionManagement 开启事务管理
 */
@Configuration
@ComponentScan(basePackages = {"com.qyhy.tx"})
@EnableTransactionManagement
public class SpringConfiguration {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(JdbcUtil.url, JdbcUtil.user, JdbcUtil.password);
    }

    @Bean
    public TransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
