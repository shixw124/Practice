package com.changan.studyJDBC;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/17 0017.
 *
 */

import java.sql.*;

public class TreeArticle {
    public static void main(String[] args) {
        new TreeArticle().show();
    }

    public void show() {
        Connection connection = null;
        Statement statement = null;
        ResultSet re = null;
        try {
            // 获取Driver
            // Class.forName("com.mysql.jdbc.Driver");
            new com.mysql.jdbc.Driver();
            // 使用DriverManager与MySql建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/bbs?" +
                    "user=root&password=shixw");
            // 建立连接之后要创建执行SQL语句的statement 接口
            statement = connection.createStatement();
            re = statement.executeQuery("select * from bbs.article where pid = 0");
            while (re.next()) {
                System.out.println(re.getString("cont"));
                tree(connection, re.getInt("id"), 1);
            }
        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        } */catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    connection = null;
                }

                if (statement != null) {
                    statement.close();
                    statement = null;
                }

                if (re != null) {
                    re.close();
                    re = null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void tree(Connection conn, int id, int level) {
        Statement statement = null;
        ResultSet resultSet = null;
        StringBuffer stringBuffer = new StringBuffer();

        // 设置树状打印的缩进
        for (int i = 0; i < level; i++) {
            stringBuffer.append("    ");
        }
        
        try {
            statement = conn.createStatement();
            String sql = "select * from article where pid = " + id;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(stringBuffer + resultSet.getString("cont"));
                if(resultSet.getInt("isleaf") != 0)
                    tree(conn, resultSet.getInt("id"), level + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                    statement = null;
                }

                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
