package com.db.tutorial.pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PgJdbcUpdateData {
    public static void main(String args[]) {
        System.out.println("开始更新数据。。。。");

        Connection connection = null;
        PreparedStatement preparedStatementstmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.111.130:5432/postgres", "postgres", "1234");
            connection.setAutoCommit(false);

            System.out.println("连接数据库成功！");

            String sql = "UPDATE COMPANY02 set SALARY = 43250 where ID=?";
            //id为Int类型，所以为id赋值使用setInt();
            preparedStatementstmt = connection.prepareStatement(sql);
            preparedStatementstmt.setInt(1, 3);
            int resultCount = preparedStatementstmt.executeUpdate();
            connection.commit();
            System.out.println("数据集更新条数：" + resultCount);

            preparedStatementstmt = null;

            String querySQL = "select * from company02 where id =?";
            preparedStatementstmt = connection.prepareStatement(querySQL);
            preparedStatementstmt.setInt(1, 3);
            ResultSet rs = preparedStatementstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println("id:" + id + ",\tname:" + name + ",\tage:" + age + ",\taddress:" + address.trim() + ",\tsalary:" + salary);
            }

            rs.close();
            preparedStatementstmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("更新数据成功！");
    }
}