package com.qyhy.tx;

import com.qyhy.tx.utils.JdbcUtil;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author zhangdj
 * @date 2020/12/03
 */
public class SpringTransaction {

    public static void main(String[] args) {
        // 创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource(JdbcUtil.url, JdbcUtil.user, JdbcUtil.password);
        TransactionTemplate template = new TransactionTemplate();
        template.setTransactionManager(new DataSourceTransactionManager(dataSource));

        template.execute(transactionStatus -> {
            Object savepoint = null;
            try {
                Connection connection = DataSourceUtils.getConnection(dataSource);
                PreparedStatement prepareStatement = connection.prepareStatement("insert into t_user(name,phone) values(?,?)");
                prepareStatement.setString(1, "chi");
                prepareStatement.setString(2, "110");
                prepareStatement.executeUpdate();
                // 创建savepoint
                savepoint = transactionStatus.createSavepoint();

                prepareStatement.setString(1, "ha");
                prepareStatement.setString(2, "111");
                prepareStatement.executeUpdate();
                throw new RuntimeException();
            } catch (Exception e) {
                if (savepoint != null) {
                    // 回滚到savePoint
                    transactionStatus.rollbackToSavepoint(savepoint);
                } else {
                    // 全部回滚
                    transactionStatus.setRollbackOnly();
                }
            }
            return null;
        });
    }
}
