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
<%--  	<a href="sxkh!listTotal.action">�ͻ�Ƿ��ͳ��</a>**<a href="hkmx!listTotal.action">�ͻ�����ͳ��</a>**<a href="<%=request.getContextPath()%>/jsp/sxkhEdit.jsp">�������ſͻ�</a>--%>
  	<a href="jsp/sxkhSel.jsp">�ͻ�Ƿ��ͳ��</a>**<a href="jsp/hkSel.jsp">�ͻ�����ͳ��</a>**<a href="<%=request.getContextPath()%>/jsp/sxkhEdit.jsp">�������ſͻ�</a>
    <table>
    <tr>
    	<th>ҵ��Ա����</th>
    	<th>�ͻ����</th>
    	<th>�ͻ�����</th>
    	<th>�����ڼ�</th>
    	<th>���Ŷ��</th>
    	<th>��ʷ�ۼ�</th>
    	<th>��ֹ��ˮ��</th>
    	<th>�Ƿ��½�</th>
    	<th>�༭</th>
    	<th>����</th>
    </tr>
    <c:if test="${!empty pm.list}">
          <c:forEach items="${pm.list}" var="sxkh">
          
          <tr>
            <td>${sxkh.ywymc}</td>
            <td>${sxkh.khbh}</td>
            <td>${sxkh.khmc}</td>
            <td>${sxkh.days}</td>
            <td>${sxkh.limit}</td>
            <td>${sxkh.balance}</td>
            <td>${sxkh.lsh}</td>
            <td>${sxkh.yjkh}</td>
            <td><a href="sxkh!editPage.action?id=${sxkh.id}">�޸�</a>&nbsp;<a id="delSxkh" href="sxkh!delete.action?id=${sxkh.id}" onclick="{if(confirm('ȷ��Ҫɾ����¼��?')){return true;}return false;}">ɾ��</a></td>
            <td><a href="xsmx.action?id=${sxkh.id}">������ϸ</a>&nbsp;<a href="xsmx!total.action?id=${sxkh.id}">���</a>&nbsp;<a href="hkmxLog.action?id=${sxkh.id}">�����¼</a></td>
          </tr>
          </c:forEach>
	</c:if>
          
          <!-- ���б�����Ϊ�յ�ʱ��Ҫ��ʾ����ʾ��Ϣ -->
	<c:if test="${empty pm.list}">
	    <tr>
	    	<td colspan="5" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	û���ҵ���Ӧ�ļ�¼
	    	</td>
	    </tr>
	</c:if>
    </table>
  </body>
</html>
