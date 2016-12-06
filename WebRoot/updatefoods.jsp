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
    
    <title>My JSP 'updatefoods.jsp' starting page</title>
    
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
		String idno=request.getParameter("id");
		FoodsDAO dao = new FoodsDAO();		
		Foods list = dao.getItemsById(Integer.parseInt(idno));
	%>
	<form action="servlet/foodManager?action=update" method="post">
	<table border="1" width="80%">					
		<tr>
			<th>菜品id</th>
			<th>菜品名称</th>
			<th>菜品分类</th>
			<th>菜品价格</th>
			<th>菜品说明</th>
			<th>菜品图片</th>
		</tr>		
		<tr>
			<td><input type="text" value="<%=list.getFood_id()%>" name="food_id" readonly="readonly"></td>
			<td><input type="text" value="<%=list.getFood_name()%>" name="food_name"></td>
			<td><input type="text" value="<%=list.getFood_classify()%>" name="food_classify"></td>
			<td><input type="text" value="<%=list.getFood_price() %>" name="food_price"></td>
			<td><input type="text" value="<%=list.getFood_declare()%>" name="food_declare"></td>
			<td><input type="text" value="<%=list.getFood_picture() %>" name="food_picture"/></td>											
		</tr>				
	</table>
	<input type="submit" value="提交"/>
	</form>
  </body>
</html>
