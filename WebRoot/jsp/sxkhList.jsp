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
    	<td>客户编号</td>
    	<td>客户名称</td>
    	<td>授信期间</td>
    	<td>授信额度</td>
    	<td>历史累计</td>
    	<td>截止流水号</td>
    	<td>是否月结</td>
    	<td>编辑</td>
    	<td>操作</td>
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
            <td><a href="sxkh!editPage.action?id=${sxkh.id}">修改</a>&nbsp;<a href="sxkh!delete.action">删除</a></td>
            <td><a href="xsmx.action?id=${sxkh.id}">销售明细</a>&nbsp;<a href="sxkh!ye.action?id=${sxkh.id}">余额</a></td>
          </tr>
          </c:forEach>
	</c:if>
          
          <!-- 在列表数据为空的时候，要显示的提示信息 -->
	<c:if test="${empty pg.list}">
	    <tr>
	    	<td colspan="5" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	没有找到相应的记录
	    	</td>
	    </tr>
	</c:if>
    </table>
  </body>
</html>
