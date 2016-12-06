<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.dao.employeeDAO"%>
<%@page import="com.entity.Employees"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employee.jsp' starting page</title>
    
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
    员工名单

	<%					
		employeeDAO dao = new employeeDAO();		
		List<Employees> list = dao.getAllItems();
	%>

	<table border="1" width="80%">	
		<tr>
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>登录账号</th>
			<th>登录密码</th>
			<th>员工角色</th>
		</tr>	
		<%
			for (Employees now : list) {
			//for (Student student : list) {
		%>
		<tr>
			<td><%=now.getEmployee_id()%></td>
			<td><%=now.getEmployee_name() %></td>
			<td><%=now.getEmployee_login_id()%></td>
			<td><%=now.getEmployee_login_password()%></td>			
			<td><%=now.getEmployee_role()%></td>
			<td><a href="servlet/employeeServlet?action=delete&id=<%=now.getEmployee_id() %>">删除</a></td>
			<td><a href="upadateEmployee.jsp?id=<%=now.getEmployee_id() %>">修改</a></td>
					
		</tr>
		<%
			}
		%>
		<tr><td><a href="houduanPage.jsp">返回管理首页</a><br/></td></tr>
	</table>
  </body>
</html>
