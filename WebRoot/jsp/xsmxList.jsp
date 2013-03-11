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
    	<td>发票编号</td>
    	<td>销售时间</td>
    	<td>还款时间</td>
    	<td>发票金额</td>
    	<td>己付金额</td>
    	<td>本次还款</td>
    </tr>
    <c:if test="${!empty pm.list}">
          <c:forEach items="${pm.list}" var="xsmx" varStatus="i">
          
          <tr>
            
            <td>${xsmx.id.xsfplsh}</td>
            <td>${xsmx.id.kpsj}</a></td>
            <td>${xsmx.id.hksj}</td>
            <td>${xsmx.id.xsje}</td>
            <td>${xsmx.id.hked}</td>
            <td><input type="text" name="hk"></input></td>
          </tr>
          </c:forEach>
	</c:if>
          
          <!-- 在列表数据为空的时候，要显示的提示信息 -->
	<c:if test="${empty pm.list}">
	    <tr>
	    	<td colspan="5" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	没有找到相应的记录
	    	</td>
	    </tr>
	</c:if>
    </table>
  </body>
</html>
