package com.qyhy.tx.utils;


import com.qyhy.tx.model.User;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * @author zhangdj
 * @date 2020/11/26
 */
public class JdbcUtil {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件读取，只会执行一次，使用静态代码块
     */
    static {
        //读取文件，获取值
        try {
            String fileName = "D:/Program Files/JetBrains/workspace/java-study/tx/src/main/resources/jdbc.properties";
            InputStream in = new BufferedInputStream(new FileInputStream(fileName));
            //1.创建Properties集合类
            Properties pro = new Properties();
            //2.加载文件
            pro.load(in);
            //3获取数据
            url = pro.getProperty("url");
            user = pro.getProperty("username");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 释放资源
     *
     * @param rs
     * @param st
     * @param conn
     */
    public static void close(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("select * from t_user where id = 1");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPhone(resultSet.getString("phone"));
            System.out.println(user);
        }
    }
}
