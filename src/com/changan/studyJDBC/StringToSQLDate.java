package com.changan.studyJDBC;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/20 0020.
 *
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToSQLDate {
    public java.sql.Date stringToSqlData(String stringDateFormat) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date_util = null;
        try {
            date_util = dateFormat.parse(stringDateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        return date_sql;
    }

    public static void main(String[] args) {
        System.out.println(new StringToSQLDate().stringToSqlData("1992-10-20 12:12:34"));
    }
}
