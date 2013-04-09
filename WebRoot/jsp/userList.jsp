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


  </head>
  
  <body>
  	欢迎${user.name} &nbsp;&nbsp;<a href="logout.action">退出</a><br>
    <hr>
    <table>
    <tr>
    	<th>用户名称</th>
    	<th>登录名</th>
    	<th>部门</th>
    	<th>状态</th>
    	<th>操作</th>
    </tr>
    <c:if test="${!empty users}">
          <c:forEach items="${users}" var="user">
          
          <tr>
            <td>${user.name}</td>
            <td>${user.username}</td>
            <td>${user.org}</td>
            <td>${user.used == '0' ? "不可用" : "可用"}</td>
            <td>
            	<a href="sxkh!editPage.action?id=${sxkh.id}">修改</a>&nbsp;
            	<a id="delSxkh" href="sxkh!delete.action?id=${sxkh.id}" onclick="{if(confirm('确定要删除记录吗?')){return true;}return false;}">删除</a>
            	<a href="privilege.action?id=${user.id}">权限</a></td>
          </tr>
          </c:forEach>
	</c:if>
          
          <!-- 在列表数据为空的时候，要显示的提示信息 -->
	<c:if test="${empty users}">
	    <tr>
	    	<td colspan="5" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	没有找到相应的记录
	    	</td>
	    </tr>
	</c:if>
    </table>
  </body>
</html>
