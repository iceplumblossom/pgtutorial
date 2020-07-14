package com.db.tutorial.pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PgJdbcSelectData {
    public static void main(String args[]) {
        System.out.println("开始查询数据。。。。");

        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.111.130:5432/postgres", "postgres", "1234");
            connection.setAutoCommit(false);

            System.out.println("连接数据库成功！");
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from company02");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");

                System.out.println("id:" + id + ",\tname:" + name + ",\tage:" + age + ",\taddress:" + address.trim() + ",\tsalary:" + salary);
            }

            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("查询数据成功！");
    }
}
