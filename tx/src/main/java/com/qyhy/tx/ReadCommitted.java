package com.qyhy.tx;

import com.qyhy.tx.model.User;
import com.qyhy.tx.utils.JdbcUtil;

import java.sql.*;

/**
 * @author zhangdj
 * @date 2020/11/26
 */
public class ReadCommitted {

    public static Object lock = new Object();

    public static void insert(User user) {
        try {
            Connection connection = JdbcUtil.getConnection();
            System.out.println("insert");
            PreparedStatement statement = connection.prepareStatement("insert into t_user(name,phone) values(?,?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getPhone());
            statement.executeUpdate();
            Thread.sleep(3000);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void select(Connection connection) {
        try {
            System.out.println("select");
            Statement statement = connection.createStatement();
            statement.execute("select * from t_user");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setPhone(resultSet.getString("phone"));
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                synchronized (lock) {
                    lock.wait();
                }
                insert(new User(2L, "w", "w"));
            } catch (InterruptedException throwables) {
                throwables.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                // 先查询 再插入数据 再查询 同一个事务中两次读取的数据不一致，出现不可重复读的问题
                Connection connection = JdbcUtil.getConnection();
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                // 提高隔离级别可以解决问题
//                connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                select(connection);
                synchronized (lock) {
                    lock.notify();
                }
                Thread.sleep(1000);
                select(connection);
                connection.close();
            } catch (Exception e) {

            }
        }).start();
    }
}
