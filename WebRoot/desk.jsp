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
   
    
    <title>My JSP 'desk.jsp' starting page</title>
    
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
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
      <tr>
       
          
          <!-- 商品循环开始 -->
           <% 
               deskDAO deskdo = new deskDAO(); 
               ArrayList<Desk> list = deskdo.getAllItems();
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  Desk desk = list.get(i);
           %>   
          <div>
             <dl>
               <dt>
               <a href="servlet/DeskSessionServlet?deskid=<%=desk.getDesk_id()%>"><img src="images/1.jpg" width="120" height="90" border="1"/></a>                
               </dt>
               <dd class="dd_name"><%=desk.getDesk_name() %></dd> 
               <dd class="dd_price">状态(0为没人1为有人):<%=desk.getDesk_status() %></dd> 
                     
             </dl>
          </div>
          <!-- 商品循环结束 -->
        
          <%
                   }
              } 
          %>
        
      </tr>      
    </table>
  </body>
</html>
