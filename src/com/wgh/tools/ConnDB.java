package com.wgh.tools;

import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.util.Properties;

public class ConnDB {

    public Connection conn = null;//声明connection实例
    public Statement stmt = null;//声明Statement实例
    public ResultSet rs = null;
    private static String proFileName = "connDB.properites";//指定资源文件保存位置
    private static Properties prop = new Properties();
    private static String dbClassName = "com.mysql.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://localhost:33060/testdb?user=root&password=123456&useUnicode=true";

    public ConnDB() {
//        try{
//            InputStream in=getClass().getResourceAsStream(proFileName);
//            prop.load(in);                                              //通过输入流对象加载Properties文件
//            dbClassName=prop.getProperty("DB_CLASS_NAME");              //获取数据库驱动
//            dbUrl=prop.getProperty("DB_URL",dbUrl);
//        }catch(Exception e){
//            e.printStackTrace();                                        //输出异常信息
//        }
    }

    /**
     * 创建数据库连接方法
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(dbClassName).newInstance();                   //装载数据库驱动
            conn = DriverManager.getConnection(dbUrl);                    //建立与数据库的连接
        } catch (Exception ee) {
            ee.printStackTrace();                                       //输出异常信息
        }
        if (conn == null) {
            //控制台输出提示信息
            System.err.println("警告：DbConnectionManager.getConnection()获取数据库连接失败。\r\n连接类型" + dbClassName + "\r\n链接位置：" + dbUrl);
        }
        return conn;                                                    //返回数据库对象
    }

    public ResultSet execute(String sql) {
        conn = getConnection();
        try {

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 执行查询语句的方法
     *
     * @param sql
     * @return
     */
    public ResultSet executeQuery(String sql) {
        try {
            conn = getConnection();                                       //调用数据库连接方法构造Connection对象的一个实例
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return rs;
    }

    /**
     * 执行数据库更新的方法
     *
     * @param sql
     * @return
     */
    public int executeUpdate(String sql) {
        int result = 0;
        try {
            conn = getConnection();                                       //调用数据库连接方法构造Connection对象的一个实例
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = stmt.executeUpdate(sql);                             //执行更新操作
        } catch (SQLException ex) {
            result = 0;
            System.err.println(ex.getMessage());
        }
        return result;
    }

    public boolean next() {
        boolean flag = true;
        if (!rs.equals(null)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 通过行号获取String值
     *
     * @param index 引导值
     * @return 返回值
     */
    public String getString(int index) {
        String result = "";
        if (!rs.equals(null)) {
            try {
                result = rs.getString(index);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        } else {
            return result;
        }
    }

    /**
     * 通过字段名获取String值
     *
     * @param col 字段名
     * @return 返回值
     */
    public String getString(String col) {
        String result = "";
        if (!rs.equals(null)) {
            try {
                result = rs.getString(col);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        } else {
            return result;
        }
    }

    /**
     * 通过行号获取Int值
     *
     * @param col 引导值
     * @return 返回值
     */
    public int getInt(String col) {
        int result = -1;
        if (!rs.equals(null)) {
            try {
                result = rs.getInt(col);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        } else {
            return result;
        }
    }

    /**
     * 通过行号获取Int值
     *
     * @param index 引导值
     * @return 返回值
     */
    public int getInt(int index) {
        int result = -1;
        if (!rs.equals(null)) {
            try {
                result = rs.getInt(index);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        } else {
            return result;
        }
    }

    /**
     * 关闭数据库连接方法
     */
    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
