<%@ page import="com.weavernorth.hrmsysnc.hrm.HrmSysnServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: ldj57
  Date: 2017/10/12
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestSync</title>
</head>
<body>

    <%
        String Log="";
        String xml="<?xml version=\"1.0\" encoding=\"gb2312\"?><root>" +
                "<mdtype>Organization</mdtype>" +
                "<data>" +
                "<Organization>" +
                "<id>1001A110000000000IP1</id>" +
                "<fcFlag>0</fcFlag>" +
                "<xh>110</xh>" +
                "<orgCode>01001</orgCode>" +
                "<mdCode>B000001163</mdCode>" +
                "<orgName>十一室</orgName>" +
                "</Organization></data></root>";

        HrmSysnServiceImpl hssi=new HrmSysnServiceImpl();
        Log=hssi.departmentSyn(xml);
        out.print(Log);
    %>
    <p><% out.print(Log); %></p>
</body>
</html>
