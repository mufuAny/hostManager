<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.dao.deskDAO"%>
<%@page import="com.entity.Desk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatedesks.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    桌子信息
	<%					
		String idno=request.getParameter("id");
		deskDAO dao = new deskDAO();			
		Desk list = dao.getItemsById(Integer.parseInt(idno));
	%>
	<form action="servlet/DeskServlet?action=update" method="post">
	<table border="1" width="80%">					
		<tr>
			<th>桌子号</th>
			<th>桌子名称</th>
			<th>桌子状态</th>			
		</tr>		
		<tr>
			<td><input type="text" value="<%=list.getDesk_id()%>" name="desk_id" readonly="readonly"></td>
			<td><input type="text" value="<%=list.getDesk_name()%>" name="desk_name"></td>
			<td><input type="text" value="<%=list.getDesk_status()%>" name="desk_status"></td>												
		</tr>				
	</table>
	<input type="submit" value="提交"/>
	</form>
  </body>
</html>
