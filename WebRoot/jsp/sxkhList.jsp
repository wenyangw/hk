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
    	<td>�ͻ����</td>
    	<td>�ͻ�����</td>
    	<td>�����ڼ�</td>
    	<td>���Ŷ��</td>
    	<td>��ʷ�ۼ�</td>
    	<td>��ֹ��ˮ��</td>
    	<td>�Ƿ��½�</td>
    	<td>�༭</td>
    	<td>����</td>
    </tr>
    <c:if test="${!empty pg.list}">
          <c:forEach items="${pg.list}" var="sxkh">
          
          <tr>
            
            <td>${sxkh.khbh}</td>
            <td>${sxkh.khmc}</a></td>
            <td>${sxkh.days}</td>
            <td>${sxkh.limit}</td>
            <td>${sxkh.balance}</td>
            <td>${sxkh.lsh}</td>
            <td>${sxkh.yjkh}</td>
            <td><a href="sxkh!editPage.action?id=${sxkh.id}">�޸�</a>&nbsp;<a href="sxkh!delete.action">ɾ��</a></td>
            <td><a href="xsmx.action?id=${sxkh.id}">������ϸ</a>&nbsp;<a href="sxkh!ye.action?id=${sxkh.id}">���</a></td>
          </tr>
          </c:forEach>
	</c:if>
          
          <!-- ���б�����Ϊ�յ�ʱ��Ҫ��ʾ����ʾ��Ϣ -->
	<c:if test="${empty pg.list}">
	    <tr>
	    	<td colspan="5" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	û���ҵ���Ӧ�ļ�¼
	    	</td>
	    </tr>
	</c:if>
    </table>
  </body>
</html>
