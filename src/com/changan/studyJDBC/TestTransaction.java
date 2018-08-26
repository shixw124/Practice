package com.changan.studyJDBC;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/20 0020.
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class TestTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?" +
                    "user=root&password=shixw");
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            stat.addBatch("insert into dept values (31, 'xj', 'mmt')");
            stat.addBatch("insert into dept values (32, 'xz', 'dl')");
            stat.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException s) {
            s.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                    stat = null;
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
