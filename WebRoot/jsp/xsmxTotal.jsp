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
    	<td>�ͻ����</td><td>${total.khbh}</td>
    </tr>
    <tr>
    	<td>Ƿ���ܶ�</td><td>${total.total}</td>
    </tr>
    <tr>
    	<td>�������ڽ��</td><td>${total.totalIn}</td>
    </tr>
    <tr>	
    	<td>����1-30��</td><td>${total.totalOut1}</td>
    </tr>
    <tr>
    	<td>����31-60��</td><td>${total.totalOut2}</td>
    </tr>
    <tr>
    	<td>����61-90��</td><td>${total.totalOut3}</td>
    </tr>
    <tr>
    	<td>����91-120��</td><td>${total.totalOut4}</td>
    </tr>
    <tr>
    	<td>����150������</td><td>${total.totalOut5}</td>
    </tr>      
    </table>
  </body>
</html>
