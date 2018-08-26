package com.changan.studyJDBC;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/20 0020.
 *
 */

import java.util.Date;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUpdateResultSet {
    public static void main(String[] args) {
        Statement stat = null;
        Connection conn = null;
        ResultSet res = null;
        Date date = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?" +
                    "user=root&password=shixw");
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = stat.executeQuery("select * from emp");
            res.next();
            // update the ename field
            res.updateString("ename", "aaaa");
            res.updateRow();

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = format.parse("1992-10-37 12:12:34");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date date1 = new java.sql.Date(date.getTime());
            res.moveToInsertRow();
            res.updateInt(1, 8888);
            res.updateString("ename", "vvvv");
            res.updateString("job", "driver");
            res.updateInt("mgr", 7777);
            res.updateDouble("sal", 8297);
            res.updateDouble("comm", 12);
            res.updateDate(5, date1);
            res.updateInt("deptno", 33);
            res.insertRow();
            //move the cursor to the new line
            res.moveToCurrentRow();

            /*
            delete row
            res.absolute(3);
            res.deleteRow();*/

            // cancel the update
            // res.cancelRowUpdates();

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
