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
  	<form action="sxkh!listTotal.action" method="post">
  	请选择统计截止的时间:
  	<select name="year" class="year">
<%--		<option value="2013">2013</option>--%>
<%--		<option value="2014">2014</option>--%>
<%--		<option value="2015">2015</option>--%>
<%--		<option value="2016">2016</option>--%>
	</select>年
	<select name="month" class="month">
<%--		<option value="1">1</option>--%>
<%--		<option value="2">2</option>--%>
<%--		<option value="3">3</option>--%>
<%--		<option value="4">4</option>--%>
<%--		<option value="5">5</option>--%>
<%--		<option value="6">6</option>--%>
<%--		<option value="7">7</option>--%>
<%--		<option value="8">8</option>--%>
<%--		<option value="9">9</option>--%>
<%--		<option value="10">10</option>--%>
<%--		<option value="11">11</option>--%>
<%--		<option value="12">12</option>--%>
	</select>月
	<br>
	<input type="submit" value="确定">
	<input type="button" value="返回" onclick="javascript:history.back()"/>
	</form>
  </body>
</html>
