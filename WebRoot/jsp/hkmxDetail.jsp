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

    <script language="javascript" type="text/javascript" > 
	$(function(){
		
		
	});
	function delete(id){
		alert(id);
	}
	</script>

  </head>
  
  <body>
  	欢迎 ${user.name} &nbsp;&nbsp;<a href="logout.action">退出</a><br>
    <hr>
  	<a href="sxkh!list.action">返回授信客户列表</a>
    <table>
    <tr>
    	<th>发票号</th>
    	<th>还款时间</th>
    	<th>还款金额</th>
    	<th>是否还清</th>
    </tr>
    <c:if test="${!empty list}">
          <c:forEach items="${list}" var="hkmx">
          
          <tr>
            <td>${hkmx.xsfplsh}</td>
            <td>${hkmx.hksj}</td>
            <td class="dataarea">${hkmx.hkje}</td>
            <td>${hkmx.completed == "1" ? "是" : "否"}</td>
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
