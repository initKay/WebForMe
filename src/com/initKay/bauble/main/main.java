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
        //int s=conn.executeUpdate(" update testtable set name='叶良成' where id=4");
//        boolean flag= conn.execute("select * from testtable");
//        System.out.print("输出结果："+flag);
        rs=conn.executeQuery("update testtable set name='叶良成' where id=4");
        try {
            while (conn.next()){
                id=conn.getInt("id");
                name=conn.getString("name");
                System.out.print("查询结果："+id+","+name);
            }
        }finally {
            conn.close();
        }

    }
}
