package com.db.tutorial.pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PgJdbcCreateTable {
    public static void main(String args[]) {
        System.out.println("开始创建新表。。。。");

        Connection connection = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.111.130:5432/postgres", "postgres", "1234");
            System.out.println("连接数据库成功！");
            stmt = connection.createStatement();
            /**
             * PG在执行SQL时是区分大小写的。如下语句在默认情况下，将不创建大写的数据库对象（表名、列名都会自动转换成小写状态）。
             * 如果在创建时将各个对象上添加了双引号，那么将变成大写状态，
             * 在执行SELECT,UPDATE,DELETE时，各个对象必须以大写状态存在。否则，报错！！
             */
            String sql = "CREATE TABLE COMPANY02 " +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    " NAME           VARCHAR(50) NOT NULL, " +
                    " AGE            SMALLINT NOT NULL, " +
                    " ADDRESS        VARCHAR(120), " +
                    " SALARY         REAL)";

            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("新表创建成功！");
    }
}