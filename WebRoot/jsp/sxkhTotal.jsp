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
    	<th>客户编号</th>
    	<th>欠款总额</th>
    	<th>超额欠款</th>
    	<th>超期30天以内</th>
    	<th>超期60天以内</th>
    	<th>超期90天以内</th>
    	<th>超期120天以内</th>
    	<th>超期120天以上</th>
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
          
          <!-- 在列表数据为空的时候，要显示的提示信息 -->
	<c:if test="${empty list}">
	    <tr>
	    	<td colspan="5" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	没有找到相应的记录
	    	</td>
	    </tr>
	</c:if>
    </table>
  </body>
</html>
