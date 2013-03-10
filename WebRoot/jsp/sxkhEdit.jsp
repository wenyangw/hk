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
  	<form action="sxkh!edit.action" method="post">
    <table border="1">
    <tr>
    	<td>客户编号</td><td><input type="texxt" name="khbh" value="${sxkh.khbh}"/></input></td>
    </tr>
    <tr>
    	<td>客户名称</td><td><input type="texxt" name="khmc" value="${sxkh.khmc}"/></input></td>
    </tr>
    <tr>
    	<td>授信期间</td><td><input type="texxt" name="days" value="${sxkh.days}"/></input></td>
    </tr>
    <tr>	
    	<td>授信额度</td><td><input type="texxt" name="limit" value="${sxkh.limit}"/></input></td>
    </tr>
    <tr>
    	<td>历史累计</td><td><input type="texxt" name="balance" value="${sxkh.balance}"/></input></td>
    </tr>
    <tr>
    	<td>截止流水号</td><td><input type="texxt" name="lsh" value="${sxkh.lsh}"/></input></td>
    </tr>
    <tr>
    	<td>是否月结</td><td><input type="texxt" name="yjkh" value="${sxkh.yjkh}"/></input></td>
    </tr>
    <tr>
    	<td><input type="submit" value="保存"/></td>
    	<td><input type="button" value="返回"/></td>
    </tr>      
    </table>
    </form>
  </body>
</html>
