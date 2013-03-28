<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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
  	<input type="hidden" name="id" value="${sxkh.id}"/>
    <table border="1">
    <tr>
    	<td>客户编号</td><td><input type="text" name="khbh" value="${sxkh.khbh}" size="30"/></input></td>
    </tr>
    <tr>
    	<td>客户名称</td><td><input type="text" name="khmc" value="${sxkh.khmc}" size="30"/></input></td>
    </tr>
    <tr>
    	<td>业务员编号</td><td><input type="text" name="ywybh" value="${sxkh.ywybh}" size="30"/></input></td>
    </tr>
    <tr>
    	<td>业务员名称</td><td><input type="text" name="ywymc" value="${sxkh.ywymc}" size="30"/></input></td>
    </tr>
    <tr>
    	<td>授信期间</td><td><input type="text" name="days" value="${sxkh.days}" size="30"/></input></td>
    </tr>
    <tr>	
    	<td>授信额度</td><td><input type="text" name="limit" value="${sxkh.limit}" size="30"/></input></td>
    </tr>
    <tr>
    	<td>历史累计</td><td><input type="text" name="balance" value="${sxkh.balance}" size="30"/></input></td>
    </tr>
    <tr>
    	<td>截止流水号</td><td><input type="text" name="lsh" value="${sxkh.lsh}" size="30"/></input></td>
    </tr>
    <tr>
    	<td>是否月结</td><td><input type="text" name="yjkh" value="${sxkh.yjkh}" size="30"/></input></td>
    </tr>
    <tr>
    	<td><input type="submit" value="保存"/></td>
    	<td><input type="button" value="返回" onclick="javascript:history.back()"/></td>
    </tr>      
    </table>
    </form>
  </body>
</html>
