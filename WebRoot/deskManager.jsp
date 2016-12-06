<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.*"%>
<%@ page import="com.dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'foods.jsp' starting page</title>
    
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
      台号信息
	<%					
		deskDAO dao = new deskDAO();		
		List<Desk> list = dao.getAllItems();
	%>

	<table border="1" width="80%">	
		<tr>
			<th>台编号</th>
			<th>台名称</th>
			<th>台状态</th>									
		</tr>		
		<%
			for (Desk now : list) {
			//for (Student student : list) {
		%>
		<tr>
			<td><%=now.getDesk_id()%></td>
			<td><%=now.getDesk_name()%></td>
			<td><%=now.getDesk_status()%></td>			
			<td><a href="servlet/DeskServlet?action=delete&id=<%=now.getDesk_id() %>">删除</a></td>
			<td><a href="updatedesks.jsp?id=<%=now.getDesk_id() %>">修改</a></td>					
		</tr>
		<%
			}
		%>
		<tr><td><a href="houduanPage.jsp">返回管理首页</a><br/></td></tr>
	</table>
  </body>
</html>
