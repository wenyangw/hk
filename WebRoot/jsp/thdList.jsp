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
    <input type="button" value="����" onclick="javascript:history.back()"/>
<%--  	<a href="sxkh!listTotal.action">�ͻ�Ƿ��ͳ��</a>**<a href="hkmx!listTotal.action">�ͻ�����ͳ��</a>**<a href="<%=request.getContextPath()%>/jsp/sxkhEdit.jsp">�������ſͻ�</a>--%>
<%--   	<a href="jsp/sxkhSel.jsp">�ͻ�Ƿ��ͳ��</a>**<a href="jsp/hkSel.jsp">�ͻ�����ͳ��</a>**<a href="<%=request.getContextPath()%>/jsp/sxkhEdit.jsp">�������ſͻ�</a> --%>
    <table>
    <tr>
    	<th>�ͻ�</th>
    	<th>�������ˮ��</th>
    	<th>���ʱ��</th>
    	<th>��Ʒ���</th>
    	<th>��Ʒ����</th>
    	<th>����</th>
    	<th>����</th>
    	<th>����</th>
    	<th>��ע</th>
    </tr>
    <c:if test="${!empty lscks}">
          <c:forEach items="${lscks}" var="thd">
          
          <tr>
            <td>${thd.id.kh}</td>
            <td>${thd.id.thdlsh}</td>
            <td>${thd.id.thsj}</td>
            <td>${thd.id.spbh}</td>
            <td>${thd.id.spmc}</td>
            <td>${thd.id.spcd}</td>
            <td>${thd.id.spsl}</td>
            <td>${thd.id.spton}</td>
            <td>${thd.id.bz}</td>
          </tr>
          </c:forEach>
	</c:if>
          
          <!-- ���б�����Ϊ�յ�ʱ��Ҫ��ʾ����ʾ��Ϣ -->
	<c:if test="${empty lscks}">
	    <tr>
	    	<td colspan="9" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	û���ҵ���Ӧ�ļ�¼
	    	</td>
	    </tr>
	</c:if>
    </table>
  </body>
</html>
