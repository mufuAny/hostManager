<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.*"%>
<%@ page import="com.dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	   hr{
	    border-color:FF7F00; 
	   }
	   div{
	      float:left;
	      margin: 10px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	</style>
  </head>
  
  <body>
    <h1>商品展示</h1>
    <hr>  
    <center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td>
          
          <!-- 商品循环开始 -->
           <%                      		           	   
               FoodsDAO foodsDao = new FoodsDAO(); 
               ArrayList<Foods> list = foodsDao.getAllItems();
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  Foods caidan = list.get(i);
           %>   
          <div>
             <dl>
               <dt>
                 <a href="details.jsp?id=<%=caidan.getFood_id()%>"><img src="images/<%=caidan.getFood_picture()%>" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=caidan.getFood_name() %></dd> 
               <dd class="dd_price">价格:<%=caidan.getFood_price() %></dd> 
               <dd class="dd_title">菜品描述:<%=caidan.getFood_declare() %></dd>       
             </dl>
          </div>
          <!-- 商品循环结束 -->
        
          <%
                   }
              }               
          %>
        </td>         
      </tr>
    </table>
    </center>
  </body>
</html>
