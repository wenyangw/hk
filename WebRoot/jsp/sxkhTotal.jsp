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
    <table>
    <tr>
    	<th>�ͻ����</th>
    	<th>Ƿ���ܶ�</th>
    	<th>����Ƿ��</th>
    	<th>����30������</th>
    	<th>����60������</th>
    	<th>����90������</th>
    	<th>����120������</th>
    	<th>����120������</th>
    </tr>
    <c:if test="${!empty list}">
          <c:forEach items="${list}" var="sxkhTotal">
          
          <tr>
            <td>${sxkhTotal.hkbh}</td>
            <td>${sxkhTotal.total}</td>
            <td>${sxkhTotal.totalIn}</td>
            <td>${sxkhTotal.totalOut1}</td>
            <td>${sxkhTotal.totalOut2}</td>
            <td>${sxkhTotal.totalOut3}</td>
            <td>${sxkhTotal.totalOut4}</td>
            <td>${sxkhTotal.totalOut5}</td>
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