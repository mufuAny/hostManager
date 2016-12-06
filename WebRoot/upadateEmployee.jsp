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
    
    <title>My JSP 'upadateEmployee.jsp' starting page</title>
    
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
       修改员工

	<%			
		String id=request.getParameter("id");		
		employeeDAO dao = new employeeDAO();		
		Employees now = dao.findById(Integer.parseInt(id));
	%>
	<form action="servlet/employeeServlet?action=update" method="post">
	<table border="1" width="80%">	
		<tr>
			<td>员工工号</td>
			<td>员工姓名</td>
			<td>登录账号</td>
			<td>登录密码</td>
			<td>员工角色</td>
		</tr>			
		<tr>
			<td><input type="text" value="<%= now.getEmployee_id()%>" name="employee_id" readonly="readonly"></td>
			<td><input type="text" value="<%= now.getEmployee_name()%>" name="employee_login_name"></td>
			<td><input type="text" value="<%=now.getEmployee_login_id() %>" name="employee_login_id"></td>
			<td><input type="text" value="<%=now.getEmployee_login_password()%>" name="employee_login_password"></td>			
			<td><input type="text" value="<%=now.getEmployee_role() %>" name="employee_login_role"></td>											
		</tr>		
	</table>
	<input type="submit" value="提交">
	</form>
  </body>
</html>
