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
    <form action="privilege!change.action" method="post">
    <input type="hidden" name="id" value="${id}">
    <table>
    <tr>
    	<th>请选择</th>
    </tr>
    <c:if test="${!empty all_menus}">
          <c:forEach items="${all_menus}" var="menu">
          
          <tr>
            <td>
            	<c:set var="flag" value="false" />
            	<c:forEach items="${user_menus}" var="umenu">
            		<c:if test="${menu.id == umenu.id}">
            			<c:set var="flag" value="true" />
            		</c:if>
            	</c:forEach>
            	<input type="checkbox" name="select" value="${menu.id}" <c:if test="${flag == true}">checked="checked"</c:if>>${menu.cname}
            </td>
            
          </tr>
          </c:forEach>
	</c:if>
          
          <!-- 在列表数据为空的时候，要显示的提示信息 -->
	<c:if test="${empty all_menus}">
	    <tr>
	    	<td colspan="5" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	没有找到相应的记录
	    	</td>
	    </tr>
	</c:if>
    </table>
    <input type="submit" value="确定" />
    <input type="button" value="返回" onclick="javascript:history.back()"/>
    </form>
  </body>
</html>
