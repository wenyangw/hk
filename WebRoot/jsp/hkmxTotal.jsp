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
  	��ӭ${user.name} &nbsp;&nbsp;<a href="logout.action">�˳�</a><br>
    <hr>
  	<a href="sxkh!list.action">�������ſͻ��б�</a>
    <table>
    <tr>
    	<th>ҵ��Ա����</th>
    	<th>�ͻ����</th>
    	<th>�ͻ�����</th>
    	<th>�����ܶ�</th>
    	<th>��ǰ30�����ڻ����</th>
    	<th>���������</th>
    	<th>�Ӻ�30�����ϻ����</th>
    </tr>
    <c:if test="${!empty list}">
          <c:forEach items="${list}" var="hkmxTotal">
          
          <tr>
          	<td>${hkmxTotal.ywymc}</td>
            <td>${hkmxTotal.khbh}</td>
            <td>${hkmxTotal.khmc}</td>
            <td>${hkmxTotal.total}</td>
            <td>${hkmxTotal.total1}</td>
            <td>${hkmxTotal.total2}</td>
            <td>${hkmxTotal.total3}</td>
          </tr>
          </c:forEach>
	</c:if>
          
          <!-- ���б�����Ϊ�յ�ʱ��Ҫ��ʾ����ʾ��Ϣ -->
	<c:if test="${empty list}">
	    <tr>
	    	<td colspan="5" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	û���ҵ���Ӧ�ļ�¼
	    	</td>
	    </tr>
	</c:if>
    </table>
  </body>
</html>
