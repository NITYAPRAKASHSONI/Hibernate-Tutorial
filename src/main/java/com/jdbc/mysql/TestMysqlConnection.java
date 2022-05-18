package com.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMysqlConnection {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           // String jdbcUrl = "jdbc:mysql//localhost:3306/student_tracker?useSSL=false";
            String jdbcUrl="jdbc:mysql://localhost:3306/student_tracker";
            String username = "root";
            String password = "root";
            con = DriverManager.getConnection(jdbcUrl, username, password);
            if (con != null) {
                System.out.println("Successfully connected to MySQL database test");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out
                    .println("An error occurred while connecting MySQL database");
            ex.printStackTrace();
        }

    }
}

