<%@ page import="java.util.Properties" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.BufferedInputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileOutputStream" %><%--
  Created by IntelliJ IDEA.
  User: ldj57
  Date: 2017/10/2
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <%
    Properties prop = new Properties();
    try{
      //读取属性文件a.properties
      InputStream in = new BufferedInputStream(new FileInputStream("/WEB-INF/prop/connDB.properties"));
      prop.load(in);     ///加载属性列表
//                         Iterator<String> it=prop.stringPropertyNames().iterator();
//                         while(it.hasNext()){
//                                 String key=it.next();
      out.println("DB_CLASS_NAME"+":"+prop.getProperty("DB_CLASS_NAME"));
//                             }
//                         in.close();

      ///保存属性到b.properties文件
      FileOutputStream oFile = new FileOutputStream("b.properties", true);//true表示追加打开
      prop.setProperty("phone", "10086");
      prop.store(oFile, "The New properties file");
      oFile.close();
    }
    catch(Exception e){
      System.out.println(e);
    }
  %>
  </body>
</html>
