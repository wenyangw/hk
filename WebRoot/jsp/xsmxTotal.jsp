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
    
    <title>业务管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=request.getContextPath() %>/style/main.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  	欢迎${user.name} &nbsp;&nbsp;<a href="logout.action">退出</a><br>
    <hr>
  <a href="sxkh!list.action">返回授信客户列表</a>
    <table border="1">
    <tr>
    	<td>业务员名称</td><td>${total.ywymc}</td>
    </tr>
    <tr>
    	<td>客户编号</td><td>${total.khbh}</td>
    </tr>
    <tr>
    	<td>客户名称</td><td>${total.khmc}</td>
    </tr>
    <tr>
    	<td>欠款总额</td><td class="dataarea">${total.total}</td>
    </tr>
    <tr>
    	<td>超额度欠款</td><td class="dataarea">${total.total == 0 ? 0 : total.total - sumOf}</td>
    </tr>
    <tr>
    	<td>授信期内金额</td><td class="dataarea">${total.totalIn}</td>
    </tr>
    <tr>	
    	<td>超期1-30天</td><td class="dataarea">${total.totalOut1}</td>
    </tr>
    <tr>
    	<td>超期31-90天</td><td class="dataarea">${total.totalOut2}</td>
    </tr>
    <tr>
    	<td>超期91-180天</td><td class="dataarea">${total.totalOut3}</td>
    </tr>
    <tr>
    	<td>超期180天以上</td><td class="dataarea">${total.totalOut4}</td>
    </tr>
    </table>
  </body>
</html>
