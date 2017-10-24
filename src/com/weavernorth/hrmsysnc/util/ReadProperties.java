package com.weavernorth.hrmsysnc.util;

import java.io.InputStream;
import java.util.Properties;

public final class ReadProperties {
    private static String subGet;
    private static String tlevelGet;
    static{
        Properties prop=new Properties();
        InputStream in=Object.class.getResourceAsStream("/com/weavernorth/hrmsysnc/util/HrmSysnc.properties");
        try {
            prop.load(in);
            subGet=prop.getProperty("subcompanyid").trim();
            tlevelGet=prop.getProperty("tlevel").trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void ReadProperties(){
//
//    }
    public static String getSubid() {
        return subGet;
    }
    public static String getTlevel(){
        return tlevelGet;
    }

}
