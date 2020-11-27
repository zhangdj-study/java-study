package com.qyhy.tx;

import com.qyhy.tx.model.User;
import com.qyhy.tx.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdj
 * @date 2020/11/26
 * 幻读测试
 */
public class PhantomTest {

    public static void insertOnConditional(User user) {
        try {
            Connection connection = JdbcUtil.getConnection();
            List<User> users = select(connection);
            for (User item : users) {
                if ("110".equals(item.getPhone())) {
                    connection.close();
                    return;
                }
            }
            System.out.println("insert");
            Thread.sleep(2000);
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

    public static List<User> select(Connection connection) {
        List<User> list = new ArrayList<>();
        try {
            System.out.println("select");
            Statement statement = connection.createStatement();
            statement.execute("select * from t_user where phone = 110");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setPhone(resultSet.getString("phone"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void main(String[] args) {
        new Thread(() -> {
            insertOnConditional(new User("l","110"));
        }).start();

        new Thread(() -> {
            insertOnConditional(new User("l","110"));
        }).start();

    }
}
