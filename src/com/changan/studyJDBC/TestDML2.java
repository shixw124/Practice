package com.changan.studyJDBC;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/18 0018.
 *
 */

import com.mysql.jdbc.log.NullLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDML2 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("parameter error, please input again!");
            // non normal exit
            System.exit(-1);
        }

        // the standard programs to parse string to int value
        int deptno = 0;
        try {
            deptno = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String dname = args[1];
        String loc = args[2];
        Connection conn = null;
        Statement stem = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?" +
                    "user=root&password=shixw");
            stem = conn.createStatement();
            String sql = "insert into dept values (" + deptno + ", '" + dname + "' ," +
                    "'" + loc + "')";
            System.out.println(sql);
            stem.executeUpdate(sql);
        } catch (SQLException e) {
            // export the exception info into the log document
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // export the exception info into the log document
            e.printStackTrace();
        } finally {
            try {
                if (stem != null) {
                    stem.close();
                    stem = null;
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
