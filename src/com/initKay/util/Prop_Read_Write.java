package com.initKay.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * author: initKay
 * Date: 2018/2/26
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 * Description:
 *             配置文件读写相关类
 */
public class Prop_Read_Write {
    private Properties prop = new Properties();
    private String ProjectPath=ProjectClassPath.getConfigPath().replace("classes", "prop");
    private String PropPath=ProjectPath;

    /**
     *  读取配置文件的方法
     * @param fieldName 需要读取的字段名
     * @param fielName 需要读取的文件名，包含.properties
     * @return 返回属性值
     */
    public String ReadProp(String fieldName,String fielName){
        prop=new Properties();
        String returnValue="";
        try {
            //读取属性文件
            InputStream in = new BufferedInputStream(new FileInputStream(PropPath+fielName));
            prop.load(in);     //加载属性列表
            returnValue=prop.getProperty(fieldName);
            System.out.println(fieldName + ":" + prop.getProperty(fieldName));
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return returnValue;
    }

    /**
     * 无需追加的写配置文件方法
     * @param fieldName 字段名
     * @param fieldVal 字段值
     * @param fielName 文件名
     */
    public void WriteProp(String fieldName,String fieldVal,String fielName){
        prop=new Properties();
        try {
            //保存属性到properties文件
            FileOutputStream oFile = new FileOutputStream(PropPath+fielName, false);//true表示追加打开
            System.out.print(PropPath+fielName);
            prop.setProperty(fieldName, fieldVal);
//            prop.store(oFile, "The New properties file");
            oFile.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 有追加标志的写配置文件方法
     * @param fieldName 字段名
     * @param fieldVal 字段值
     * @param fielName 文件名
     * @param append 追加标志
     */
    public void WriteProp(String fieldName,String fieldVal,String fielName,boolean append){
        //如果追加标志为true则进行追加写配置文件
        if (append){
            try {
                //保存属性到properties文件
                FileOutputStream oFile = new FileOutputStream(PropPath+fielName,true);//true表示追加打开
                System.out.print(PropPath+fielName);
                prop.setProperty(fieldName, fieldVal);
                prop.store(oFile, "The New properties file");
                oFile.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }else {
            //否则不可进行无需追加的写配置文件
            WriteProp(fieldName,fieldVal,fielName);
        }
    }
}
