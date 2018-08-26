package com.changan.studyJDBC;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/20 0020.
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * test the usage of the PreparedStatement!
 */
public class TestPreparedStatemetnt {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("the parameters error! please input!");
            System.exit(-1);
        }

        int deptno = 0;
        try {
            deptno = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String dname = args[1];
        String loc = args[2];
        Connection conn = null;
        PreparedStatement prepStem = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?" +
                    "user=root&password=shixw");
            // the three "？" represent three placeholders
            // these placeholders can be replaced by other values through the method setxxx()
            prepStem = conn.prepareStatement("insert into dept values (?, ?, ?)");
            prepStem.setInt(1, deptno);
            prepStem.setString(2, dname);
            prepStem.setString(3, loc);
            prepStem.executeUpdate();
        } catch (SQLException e) {
            // the exception should be exported into the log document
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // the exception should be exported into the log document
            e.printStackTrace();
        } finally {
            try {
                if (prepStem != null) {
                    prepStem.close();
                    prepStem = null;
                }

                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                // the exception should be exported into the log document
                e.printStackTrace();
            }
        }

    }
}
