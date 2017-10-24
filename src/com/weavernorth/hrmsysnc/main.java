package com.weavernorth.hrmsysnc;

import com.weavernorth.hrmsysnc.hrm.HrmSysnServiceImpl;
import com.weavernorth.hrmsysnc.util.ReadProperties;

public class main {

    public static void main(String[] args){
        ReadProperties rp=new ReadProperties();

        String xml="<?xml version=\"1.0\" encoding=\"gb2312\"?><root>" +
                "<mdtype>Organization</mdtype>" +
                "<data>" +
                "<Organization>" +
                "<id>1001A110000000000IP1</id>" +
                "<fcFlag>0</fcFlag>" +
                "<xh>110</xh>" +
                "<orgCode>01001</orgCode>" +
                "<mdCode>B000001163</mdCode>" +
                "<orgName>一室</orgName>" +
                "</Organization></data></root>";

        HrmSysnServiceImpl hssi=new HrmSysnServiceImpl();
        hssi.departmentSyn(xml);
        System.out.println(rp.getSubid());
        System.out.println(rp.getTlevel());

    }
}
