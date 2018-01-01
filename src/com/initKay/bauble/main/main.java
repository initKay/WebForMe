package com.initKay.bauble.main;

import com.initKay.util.PropServer;
import com.wgh.tools.ConnDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class main {

    public static void main(String[] args) {
        ConnDB conn=new ConnDB();
        ResultSet rs;
        String name="";
        int id = 0;
        rs=conn.executeQuery("select * from testtable");
        try {
            while (rs.next()){
               id=conn.getInt("id");
                name=conn.getString("name");
                System.out.print("查询结果："+id+","+name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }

    }
}
