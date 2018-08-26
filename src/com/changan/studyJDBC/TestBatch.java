package com.changan.studyJDBC;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/20 0020.
 *
 */

import java.sql.*;

public class TestBatch {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        PreparedStatement preStat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?" +
                    "user=root&password=shixw");
            /*stat = conn.createStatement();
            String sql = "insert into dept values (23, 'ty', 'hl')";
            String sql1 = "insert into dept values (25, 'ty', 'hl')";
            stat.addBatch(sql);
            stat.addBatch(sql1);
            stat.executeBatch();*/

            preStat = conn.prepareStatement("delete from dept where loc = ? ");
            preStat.setString(1, "ss");
            preStat.addBatch();
            preStat.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                    stat = null;
                }

                if (preStat != null) {
                    preStat.close();
                    preStat = null;
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
