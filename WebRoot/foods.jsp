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
      菜单信息

	<%					
		FoodsDAO dao = new FoodsDAO();		
		List<Foods> list = dao.getAllItems();
	%>

	<table border="1" width="80%">	
		<tr>
			<th>菜品id</th>
			<th>菜品名称</th>
			<th>菜品分类</th>
			<th>菜品价格</th>
			<th>菜品说明</th>
			<th>菜品图片</th>
		</tr>		
		<%
			for (Foods now : list) {
			//for (Student student : list) {
		%>
		<tr>
			<td><%=now.getFood_id()%></td>
			<td><%=now.getFood_name()%></td>
			<td><%=now.getFood_classify()%></td>
			<td><%=now.getFood_price() %></td>
			<td><%=now.getFood_declare()%></td>
			<td><%=now.getFood_picture() %></td>
			<td><a href="servlet/foodManager?action=delete&id=<%=now.getFood_id() %>">删除</a></td>
			<td><a href="updatefoods.jsp?id=<%=now.getFood_id() %>">修改</a></td>					
		</tr>
		<%
			}
		%>
		<tr><td><a href="houduanPage.jsp">返回管理首页</a><br/></td></tr>
	</table>
  </body>
</html>
