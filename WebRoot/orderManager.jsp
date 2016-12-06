<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.dao.OrderDao"%>
<%@page import="com.entity.Order"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderManager.jsp' starting page</title>
    
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
		OrderDao dao = new OrderDao();		
		List<Order> list = dao.getAllOrderList();
	%>

	<table border="1" width="80%">	
		<tr>
			<th>订单编号</th>
			<th>订单时间</th>
			<th>订单金额</th>
			<th>订单折扣</th>
			<th>订单终价</th>
			<th>菜品数量</th>
			<th>顾客桌号</th>
			<th>顾客名称</th>
			<th>订单状态</th>
			<th>员工工号</th>
			<th>员工姓名</th>									
		</tr>		
		<%
			for (Order now : list) {
			//for (Student student : list) {
		%>
		<tr>
			<td><%=now.getOrder_id()%></td>
			<td><%=now.getOrder_time()%></td>
			<td><%=now.getOrder_money()%></td>
			<td><%=now.getOrder_discount()%></td>
			<td><%=now.getOrder_end_price()%></td>
			<td><%=now.getFood_count()%></td>
			<td><%=now.getClient_desk_id()%></td>
			<td><%=now.getClient_name()%></td>
			<td><%=now.getOrder_status()%></td>
			<td><%=now.getEmployee_id()%></td>
			<td><%=now.getEmployee_name()%></td>
			
						
			<td><a href="servlet/do_client_inter?action=delect&id=<%=now.getOrder_id() %>">删除</a></td>
								
		</tr>
		<%
			}
		%>
		<tr><td><a href="houduanPage.jsp">返回管理首页</a><br/></td></tr>
	</table>
  </body>
</html>
