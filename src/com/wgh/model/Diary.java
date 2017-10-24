package com.wgh.model;

import java.util.Date;

public class Diary {
    private int id=0;           //日记id
    private String title="";    //日记标题
    private String adress="";   //日记地址
    private Date writeTime=null;//日记时间
    private int userid=0;
    private String username=""; //用户名

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
}
