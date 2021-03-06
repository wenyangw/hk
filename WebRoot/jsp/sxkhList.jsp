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
<%--  	<a href="sxkh!listTotal.action">客户欠款统计</a>**<a href="hkmx!listTotal.action">客户还款统计</a>**<a href="<%=request.getContextPath()%>/jsp/sxkhEdit.jsp">增加授信客户</a>--%>
  	<a href="jsp/sxkhSel.jsp">客户欠款统计</a>**<a href="jsp/hkSel.jsp">客户还款统计</a>**<a href="<%=request.getContextPath()%>/jsp/sxkhEdit.jsp">增加授信客户</a>
    <table>
    <tr>
    	<th>业务员名称</th>
    	<th>客户编号</th>
    	<th>客户名称</th>
    	<th>授信期间</th>
    	<th>授信额度</th>
    	<th>历史累计</th>
    	<th>截止流水号</th>
    	<th>是否月结</th>
    	<th>编辑</th>
    	<th>操作</th>
    </tr>
    <c:if test="${!empty pm.list}">
          <c:forEach items="${pm.list}" var="sxkh">
          
          <tr>
            <td>${sxkh.ywymc}</td>
            <td>${sxkh.khbh}</td>
            <td>${sxkh.khmc}</td>
            <td>${sxkh.days}</td>
            <td class="dataarea">${sxkh.limit}</td>
            <td class="dataarea">${sxkh.balance}</td>
            <td>${sxkh.lsh}</td>
            <td>${sxkh.yjkh}</td>
            <td><a href="sxkh!editPage.action?id=${sxkh.id}">修改</a>&nbsp;<a id="delSxkh" href="sxkh!delete.action?id=${sxkh.id}" onclick="{if(confirm('确定要删除记录吗?')){return true;}return false;}">删除</a></td>
            <td><a href="xsmx.action?id=${sxkh.id}">销售明细</a>&nbsp;<a href="xsmx!total.action?id=${sxkh.id}">余额</a>&nbsp;<a href="hkmxLog.action?id=${sxkh.id}">还款记录</a></td>
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
