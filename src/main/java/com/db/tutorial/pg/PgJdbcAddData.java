package com.db.tutorial.pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PgJdbcAddData {
    public static void main(String args[]) {
        System.out.println("开始新增数据。。。。");

        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.111.130:5432/postgres", "postgres", "1234");
            //设置事务为非自动提交
            connection.setAutoCommit(false);

            System.out.println("连接数据库成功！");
            stmt = connection.createStatement();

            //创建增加数据SQL语句
            String sql = "INSERT INTO COMPANY02 (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY02 (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY02 (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY02 (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close();
            //手动提交事务
            connection.commit();
            //关闭连接
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("新增数据成功！");
    }
}
