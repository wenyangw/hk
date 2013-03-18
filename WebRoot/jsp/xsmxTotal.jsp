<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>

<%@include file="../common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sxkhList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=request.getContextPath() %>/style/main.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <table border="1">
    <tr>
    	<td>客户编号</td><td>${total.khbh}</td>
    </tr>
    <tr>
    	<td>欠款总额</td><td>${total.total}</td>
    </tr>
    <tr>
    	<td>授信期内金额</td><td>${total.totalIn}</td>
    </tr>
    <tr>	
    	<td>超期1-30天</td><td>${total.totalOut1}</td>
    </tr>
    <tr>
    	<td>超期31-60天</td><td>${total.totalOut2}</td>
    </tr>
    <tr>
    	<td>超期61-90天</td><td>${total.totalOut3}</td>
    </tr>
    <tr>
    	<td>超期91-120天</td><td>${total.totalOut4}</td>
    </tr>
    <tr>
    	<td>超期150天以上</td><td>${total.totalOut5}</td>
    </tr>      
    </table>
  </body>
</html>
