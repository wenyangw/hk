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
    
    <title>业务管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="<%=request.getContextPath() %>/style/main.css" rel="stylesheet" type="text/css" />
	<script type=text/javascript src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script> 


  </head>
  
  <body>
  	欢迎${user.name} &nbsp;&nbsp;<a href="logout.action">退出</a><br>
    <hr>
    <input type="button" value="返回" onclick="javascript:history.back()"/>
<%--  	<a href="sxkh!listTotal.action">客户欠款统计</a>**<a href="hkmx!listTotal.action">客户还款统计</a>**<a href="<%=request.getContextPath()%>/jsp/sxkhEdit.jsp">增加授信客户</a>--%>
<%--   	<a href="jsp/sxkhSel.jsp">客户欠款统计</a>**<a href="jsp/hkSel.jsp">客户还款统计</a>**<a href="<%=request.getContextPath()%>/jsp/sxkhEdit.jsp">增加授信客户</a> --%>
    <table>
    <tr>
    	<th>客户</th>
    	<th>提货单流水号</th>
    	<th>提货时间</th>
    	<th>商品编号</th>
    	<th>商品名称</th>
    	<th>产地</th>
    	<th>数量</th>
    	<th>吨数</th>
    	<th>备注</th>
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
          
          <!-- 在列表数据为空的时候，要显示的提示信息 -->
	<c:if test="${empty lscks}">
	    <tr>
	    	<td colspan="9" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	没有找到相应的记录
	    	</td>
	    </tr>
	</c:if>
    </table>
  </body>
</html>
