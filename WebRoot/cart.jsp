<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="com.entity.*" %>
<%@page import="java.text.SimpleDateFormat"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'cart.jsp' starting page</title>
 	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link type="text/css" rel="stylesheet" href="css/style1.css" />
    <script language="javascript">
	    function delcfm() {
	        if (!confirm("确认要删除？")) {
	            window.event.returnValue = false;
	        }
	    }
   </script>
  </head>
  
  <body>
   <h1>您的订单</h1>
   <a href="index.jsp">首页>> <a href="index.jsp">商品列表</a>
   <hr> 
   <div id="shopping">
   <form action="servlet/do_client_inter?action=insert" method="post">	   		   			
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品单价</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<% 					
				   //首先判断session中是否有购物车对象
				   if(request.getSession().getAttribute("cart")!=null)
				   {
				%>
				<!-- 循环的开始 -->
				     <% 
				         Foodlist cart = (Foodlist)request.getSession().getAttribute("cart");
				         HashMap<Foods,Integer> goods = cart.getGoods();
				         Set<Foods> items = goods.keySet();
				         Iterator<Foods> it = items.iterator();
				         
				         while(it.hasNext())
				         {
				            Foods i = it.next();
				     %> 
				<tr name="products" id="product_id_1">
					<td class="thumb"><img src="images/<%=i.getFood_picture()%>" /><a href=""><%=i.getFood_name()%></a></td>					
					<td class="price" id="price_id_1">
						<span><%=i.getFood_price()*goods.get(i) %></span>
						<input type="hidden" value="" />
					</td>
					<td class="number">
                     	<%=goods.get(i)%>					
					</td>                        
                    <td class="delete">
					  <a href="servlet/Foodservlet?action=delete&id=<%=i.getFood_id()%>" onclick="delcfm();">删除</a>					                  
					</td>
				</tr>
				     <% 
				         }
				     %>
				<!--循环的结束-->	
				<tr>					 										
					<td>总价：<input type="text"  name="money" value="<%=cart.getTotalPrice() %>" readonly="readonly"/>￥</td>
					<td>数量：<input type="text" value="<%=cart.getShu() %>" name="count" readonly="readonly"/></td>
				</tr>
						<%
						}
						 %>	
			<%if(request.getSession().getAttribute("iddesk")!=null){ %>
				<tr><td>桌号：<input type="text" name="deskselect_id" value="<%=request.getSession().getAttribute("iddesk")%>"  readonly="readonly"></td></tr>
			<%} %>							 
			</table>					 
			<input type="submit" value="提交">
		</form>
	</div>
  </body>
</html>
