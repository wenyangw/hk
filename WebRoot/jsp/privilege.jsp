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
    
    <title>ҵ�����</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="<%=request.getContextPath() %>/style/main.css" rel="stylesheet" type="text/css" />
	<script type=text/javascript src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script> 


  </head>
  
  <body>
  	��ӭ${user.name} &nbsp;&nbsp;<a href="logout.action">�˳�</a><br>
    <hr>
    <table>
    <tr>
    	<th>��ѡ��</th>
    </tr>
    <c:if test="${!empty all_menus}">
          <c:forEach items="${all_menus}" var="menu">
          
          <tr>
            <td><input type="checkbox">${menu.cname}</td>
          </tr>
          </c:forEach>
	</c:if>
          
          <!-- ���б�����Ϊ�յ�ʱ��Ҫ��ʾ����ʾ��Ϣ -->
	<c:if test="${empty all_menus}">
	    <tr>
	    	<td colspan="5" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	û���ҵ���Ӧ�ļ�¼
	    	</td>
	    </tr>
	</c:if>
    </table>
  </body>
</html>
