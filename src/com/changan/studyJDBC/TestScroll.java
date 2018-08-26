package com.changan.studyJDBC;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/20 0020.
 *
 */

import java.sql.*;

public class TestScroll {
    public static void main(String[] args) {
        Statement stat = null;
        Connection conn = null;
        ResultSet res = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?" +
                    "user=root&password=shixw");
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            res = stat.executeQuery("select * from dept order by loc");
            res.next();
            System.out.println(res.getInt(1));
            res.last();
            System.out.println(res.getString(1));
            System.out.println(res.isLast());
            System.out.println(res.isAfterLast());
            System.out.println(res.getRow());
            res.previous();
            System.out.println(res.getString(1));
            res.absolute(6);
            System.out.println(res.getString(1));
            //stat.executeUpdate("delete from dept where loc = 'BJ'");
        } catch (ClassNotFoundException e) {
            // import the exception to the LOG documents;
            e.printStackTrace();
        } catch (SQLException e) {
            // import the exception to the LOG documents;
            e.printStackTrace();
        } finally {
            try {
                if (res != null) {
                    res.close();
                    res = null;
                }

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
