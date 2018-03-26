package com.initKay.bauble.main;

import com.initKay.util.ProjectClassPath;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * author: initKay
 * Date: 2018/1/2
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class testMain {
    public static void main(String[] args) {
        ProjectClassPath projectClassPath = new ProjectClassPath();

        ProjectClassPath.getConfigPath();
        Properties prop = new Properties();
        try {
            //读取属性文件a.properties
            InputStream in = new BufferedInputStream(new FileInputStream("web/WEB-INF/prop/connDB.properties"));
            prop.load(in);     ///加载属性列表
//                         Iterator<String> it=prop.stringPropertyNames().iterator();
//                         while(it.hasNext()){
//                                 String key=it.next();
            System.out.println("DB_CLASS_NAME" + ":" + prop.getProperty("DB_CLASS_NAME"));
//                             }
            in.close();

            ///保存属性到b.properties文件
            FileOutputStream oFile = new FileOutputStream("web/WEB-INF/prop/connDB.properties", false);//true表示追加打开
            prop.setProperty("phone", "10084");
            prop.setProperty("mobile", "10086");
            prop.setProperty("test", "90909");
            prop.setProperty("test22", "90909");
            prop.propertyNames();
            prop.setProperty("test26", "90909");
            prop.store(oFile, "The New properties file");
            oFile.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
//public String spath = "appconfig";


