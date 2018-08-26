package com.changan.studyJDBC;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/17 0017.
 *
 */

import java.sql.*;

public class TestMySQLConnection {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet res = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/mydata?" +
                            "user=root&password=shixw");
            statement = conn.createStatement();
            res = statement.executeQuery("select * from dept");
            while (res.next()) {
                System.out.println(res.getString("deptno"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            try {
                if (res != null) {
                    res.close();
                    res = null;
                }

                if (statement != null) {
                    statement.close();
                    statement = null;
                }

                if (conn != null) {
                    conn.close();
                    conn = null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
