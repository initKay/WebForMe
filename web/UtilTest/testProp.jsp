<%@ page import="com.initKay.util.Prop_Read_Write" %>
<%@ page import="com.initKay.util.ProjectClassPath" %><%--
  Created by IntelliJ IDEA.
  author: initKay
  Date: 2018/2/26
  Time: 11:25
  To change this template use File | Settings | File Templates.
  Description:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>配置文件读写</title>
</head>
<body>
<p align="center">测试页</p>
    <% ProjectClassPath projectClassPath=new ProjectClassPath();
        String path=projectClassPath.getConfigPath();
        Prop_Read_Write prop=new Prop_Read_Write();
        prop.WriteProp("test1","0009","connDB.properties");
        prop.WriteProp("test2","0008","connDB.properties");
        prop.WriteProp("test3","0007","connDB.properties");
        prop.WriteProp("test4","0006","connDB.properties");
    %>
<p align="center">获取的路径：<%=path%></p>
</body>
</html>
