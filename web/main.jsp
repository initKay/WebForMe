<%--
  Created by IntelliJ IDEA.
  User: ldj57
  Date: 2017/10/2
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type"content="text/html;charset=UTF-8">
    <title>日记网主页</title>
    <style>
        body{
            margin: 0px;//设置外边距
            padding: 0px;//设置内边距
            font-size: 9pt;//设置字体大小
        }
        #box{
            margin:0 auto auto auto;
            width:800px;//设置页面宽度
            clear: both;//设置两侧不可有浮动信息
            background-color: #ffffff;
        }
    </style>
</head>
<body>
    <div  id="box">
        <%@include file="top.jsp" %>
        <%@include file="register.jsp"%>

        日记网主页
        <!--显示日记列表-->
        <%@include file="bottom.jsp"%>
    </div>
</body>
</html>
