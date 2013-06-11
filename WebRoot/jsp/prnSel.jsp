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
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/util.js"></script>
	<script type=text/javascript src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	
	<script type="text/javascript">
	$(function(){
		var now = new Date();
		for(var i = 0; i< 4; i++){
			var yearI = i + 2012;
			if(yearI == now.getFullYear())
				$("select.year").append("<option value=" + yearI + " selected='selected'>" + yearI + "</option>");
			else{
				$("select.year").append("<option value=" + yearI + ">" + yearI + "</option>");
			}
		}
		for(var i = 1; i< 13; i++){
			if(i == now.getMonth() + 1){
				$("select.month").append("<option value=" + i + " selected='selected'>" + i + "</option>");
			}else{
				$("select.month").append("<option value=" + i + ">" + i + "</option>");
			}
		}
	});
	</script>
	
  </head>
  
  <body>
  	欢迎 ${user.name} &nbsp;&nbsp;<a href="logout.action">退出</a><br>
    <hr>
  	<form action="xsmx!print.action" method="post">
  		<input type="hidden" name="id" value="${param.sxkhId}">
  		请选择统计截止的时间:
  		<select name="year" class="year">
		</select>年
		<select name="month" class="month">
		</select>月
		<br>
		<input type="submit" value="打印"   onclick="showloading('正在处理数据，请稍等。。。')">
		<input type="button" value="返回" onclick="javascript:history.back()"/>
	</form>
  </body>
</html>
