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
  	<form action="sxkh!edit.action" method="post">
    <table border="1">
    <tr>
    	<td>�ͻ����</td><td><input type="texxt" name="khbh" value="${sxkh.khbh}"/></input></td>
    </tr>
    <tr>
    	<td>�ͻ�����</td><td><input type="texxt" name="khmc" value="${sxkh.khmc}"/></input></td>
    </tr>
    <tr>
    	<td>�����ڼ�</td><td><input type="texxt" name="days" value="${sxkh.days}"/></input></td>
    </tr>
    <tr>	
    	<td>���Ŷ��</td><td><input type="texxt" name="limit" value="${sxkh.limit}"/></input></td>
    </tr>
    <tr>
    	<td>��ʷ�ۼ�</td><td><input type="texxt" name="balance" value="${sxkh.balance}"/></input></td>
    </tr>
    <tr>
    	<td>��ֹ��ˮ��</td><td><input type="texxt" name="lsh" value="${sxkh.lsh}"/></input></td>
    </tr>
    <tr>
    	<td>�Ƿ��½�</td><td><input type="texxt" name="yjkh" value="${sxkh.yjkh}"/></input></td>
    </tr>
    <tr>
    	<td><input type="submit" value="����"/></td>
    	<td><input type="button" value="����"/></td>
    </tr>      
    </table>
    </form>
  </body>
</html>
