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
			var th = "<th>���λ�����</th>";
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
						$(this).append("<td class='hkTd'></td>");
				}else{
					$(this).append("<td class='hkTd'>" + hkje.toFixed(4) + "</td>");
				}
				//alert("��" + index + "�е�������" + $(this).text() + "/" + $(".hkedTd").eq(index).text());
				
			})
			$("#btnOk").css("display", "none");
			$("#btnCancel").css("display", "inline");
			$("#btnHk").css("display", "inline");
		})
		$("#btnCancel").bind("click", function(){
			$("#btnOk").css("display", "inline");
			$("#btnCancel").css("display", "none");
			$("#btnHk").css("display", "none");
			$("#tb>thead>tr>th:eq(5)").remove();
			$("td.hkTd").remove();
			
		})
		$("#btnHk").bind("click", function(){
			var hkmx = "[";
			$("#tb>tbody>tr").each(function(index){
				hkmx += "{'xsfplsh':'" + $(".lshTd").eq(index).text() + "','hkje':" + $(".hkTd").eq(index).text() + "},";
			});
			hkmx += "]";
			alert(hkmx);
		})
    });
    </script>

  </head>
  
  <body>
  	<form action="hkmx.action" method="post">
  	�����뱾�λ����ܽ�<input type="text" name="hkje" id="hkzje" />
  	<input type="button" id="btnOk" value="ȷ��" />
  	<input type="button" id="btnCancel" value="ȡ��" />
  	<input type="button" id="btnHk" value="ȷ������" />
	</form>
    <table id="tb">
    <thead>
    <tr>
    	<th>��Ʊ���</th>
    	<th>����ʱ��</th>
    	<th>����ʱ��</th>
    	<th>��Ʊ���</th>
    	<th>�ѻ�����</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty pm.list}">
          <c:forEach items="${pm.list}" var="xsmxs" varStatus="i">
          
          <tr>
            
            <td class="lshTd">${xsmxs.xsfplsh}</td>
            <td>${xsmxs.kpsj}</td>
            <td>${xsmxs.hksj}</td>
            <td class="xsjeTd">${xsmxs.xsje}</td>
            <td class="hkedTd">${xsmxs.xsfplsh == hkmx.xsfplsh ? hkmx.hkje : ""}</td>
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
	</tbody>
    </table>
  </body>
</html>
