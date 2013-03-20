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
	<script type=text/javascript src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script> 

    <script language="javascript" type="text/javascript" > 
	$(function(){
		$("#btnCancel").css("display", "none");
		$("#btnHk").css("display", "none");
		$("#btnOk").bind("click" ,function(){
			var hkzje = $("#hkzje").val();
			var th = "<th>本次还款金额</th>";
			$("#tb>thead>tr").append(th);
			//alert("Button is clicked");
			$("#tb>tbody>tr").each(function(index){
				var hkje = 0.00;
				
				if(hkzje > 0){
					 
					var xsje = $(".xsjeTd").eq(index).text();
					//alert(xsje);
					var hked = $(".hkedTd").eq(index).text();
					//alert(hked);
					hkje = Number(xsje) - Number(hked);
					
					if(hkje > hkzje){
						hkje = hkzje;
					}
					hkzje -= hkje;
				}
				
				if(hkje == 0){
						$(this).append("<td></td>");
				}else{
					$(this).append("<td>" + hkje.toFixed(4) + "</td>");
				}
				//alert("第" + index + "行的数据是" + $(this).text() + "/" + $(".hkedTd").eq(index).text());
				
			})
			$("#btnOk").css("display", "none");
			$("#btnCancel").css("display", "inline");
			$("#btnHk").css("display", "inline");
		})
		$("#btnCancel").bind("click", function(){
			$("#btnOk").css("display", "inline");
			$("#btnCancel").css("display", "none");
			$("#btnHk").css("display", "none");
			
		})
    //使用jquery 取得table 中td里面的值 
    	$("#tb td").click(function(){ 
    		alert($(this).text()); 
    	})
    });
	function addCol() {  
            $th = $("<th>本次还款金额</th>");  
            $col = $("<td></td>");  
            $("#tb>thead>tr").append($th);  
            $("#tb>tbody>tr").append($col);  
        }  
    </script>

  </head>
  
  <body>
  	<form action="hkmx.action" method="post">
  	请输入本次还款总金额：<input type="text" name="hkje" id="hkzje" />
  	<input type="button" id="btnOk" value="确定" />
  	<input type="button" id="btnCancel" value="取消" />
  	<input type="submit" id="btnHk" value="确定还款" />
	</form>
    <table id="tb">
    <thead>
    <tr>
    	<th>发票编号</th>
    	<th>销售时间</th>
    	<th>还款时间</th>
    	<th>发票金额</th>
    	<th>已还款金额</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty pm.list}">
          <c:forEach items="${pm.list}" var="xsmxs" varStatus="i">
          
          <tr>
            
            <td>${xsmxs.xsfplsh}</td>
            <td>${xsmxs.kpsj}</td>
            <td>${xsmxs.hksj}</td>
            <td class="xsjeTd">${xsmxs.xsje}</td>
            <td class="hkedTd">${xsmxs.xsfplsh == hkmx.xsfplsh ? hkmx.hkje : ""}</td>
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
	</tbody>
    </table>
  </body>
</html>
