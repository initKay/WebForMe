package com.initKay.util;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: initKay
 * Date: 2017/12/9
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class PropServer {
    public PropServer(){}
    private static Properties prop=new Properties();

    public String getPorpMessage(String propPath,String fieldName){
        String returnValue="";
        InputStream in= null;
        try {
            in = new FileInputStream(propPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(in);
            returnValue=prop.getProperty(fieldName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    public void setPropMessage(String propPath,String fieldName,String fieldValue) throws FileNotFoundException {
//        InputStream in=getClass().getResourceAsStream(propPath);
//        InputStream in = new BufferedInputStream(new FileInputStream(propPath));
        try {
            InputStream in = new BufferedInputStream (new FileInputStream(propPath));
            prop.load(in);
            prop.setProperty(fieldName,fieldValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
