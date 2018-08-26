package com.changan.studyJDBC;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/18 0018.
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * test MySQL statements: insert\\delete\\update
 */
public class TestDML1 {

    public static void main(String[] args) {
        Statement stat = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?" +
                    "user=root&password=shixw");
            stat = conn.createStatement();
            // execute insert/update/delete operations
            // stat.executeUpdate("insert into dept values (77, 'ss', 'SS')");
            stat.executeUpdate("update dept set loc = 'XA' where loc = 'd'");
            //stat.executeUpdate("delete from dept where loc = 'BJ'");
        } catch (ClassNotFoundException e) {
            // import the exception to the LOG documents;
            e.printStackTrace();
        } catch (SQLException e) {
            // import the exception to the LOG documents;
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
