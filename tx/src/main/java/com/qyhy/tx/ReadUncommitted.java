package com.qyhy.tx;

import com.qyhy.tx.model.User;
import com.qyhy.tx.utils.JdbcUtil;

import java.sql.*;

/**
 * @author zhangdj
 * @date 2020/11/26
 */
public class ReadUncommitted {

    public static void insert(User user,Connection connection) {
        try {
            System.out.println("insert");
            PreparedStatement statement = connection.prepareStatement("insert into t_user(id,name,phone) values(?,?,?)");
            statement.setLong(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3,user.getPhone());
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
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 启动插入线程
        new Thread(() -> {
            try {
                Connection connection = JdbcUtil.getConnection();
                connection.setAutoCommit(false);
                insert(new User(111L,"q","q"),connection);
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }).start();

        // 启动查询线程
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                Connection connection = JdbcUtil.getConnection();
                // 隔离级别设置为未提交读 会出现脏读
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                // 设置隔离级别为已提交读 可以解决脏读问题
//                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                select(connection);
                connection.close();
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
