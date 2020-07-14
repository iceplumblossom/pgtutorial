package com.db.tutorial.pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgJdbcConn {
    @SuppressWarnings("unused")
    public static void main(String args[]) {
        System.out.println("！！！！以下示例使用JDBC方式连接及操纵数据库相关对象！！！！");

        Connection connection = null;
        try {

            System.out.println("开始连接PG数据库。。。");
            Class.forName("org.postgresql.Driver");
            /**
             * 第一个参数说明：
             * 192.168.111.130：目标数据库IP地址
             * 5432：数据库端口号
             * postgres：目标数据库名称
             *
             * 第二个参数说明：
             * 目标数据库的连接用户名
             *
             * 第三个参数说明：
             * 连接用户名对应的密码
             */
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.111.130:5432/postgres", "postgres", "1234");
            System.out.println("数据库连接成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            try {
                System.out.println();
                System.out.println("开始关闭PG数据库。。。");
                connection.close();
                System.out.println("数据库关闭成功！！");
            } catch (SQLException throwables) {
                System.err.println("数据库关闭失败！！");
                throwables.printStackTrace();
            }
        }
    }
}