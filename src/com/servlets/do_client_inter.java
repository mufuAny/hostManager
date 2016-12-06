package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoodsDAO;
import com.dao.OrderDao;
import com.entity.Order;

/*
 * 客户订单添加类
 */
public class do_client_inter extends HttpServlet {

	private String action="" ; //表示购物车的动作 ,add,show,delete
	 FoodsDAO dd=new FoodsDAO();
	 OrderDao orderDao=new OrderDao();
	/**
	 * Constructor of the object.
	 */
	public do_client_inter() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {				
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();												
		
		if(request.getParameter("action")!=null)
		{
			this.action=request.getParameter("action");
			out.print(action);
			if(action.equals("insert")){
				if(orderInsert(request,response)){					
					request.getRequestDispatcher("/ok.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/ok.jsp").forward(request, response);
				}
			}
			
			if(action.equals("delect")){
				if(orderDelect(request,response)){
					request.getRequestDispatcher("/orderManager.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/orderManager.jsp").forward(request, response);
				}
			}
		}
	}

	private boolean orderDelect(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		if(orderDao.deleteById(id)>0){
 			return true;
 		}
 		
		return false;
	}

	//录入顾客点菜信息
	private boolean orderInsert(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		//桌号
		int deskno=Integer.parseInt(request.getParameter("deskselect_id"));
		//菜品数量
		int count=Integer.parseInt(request.getParameter("count"));
		//总计金额
		String money=request.getParameter("money");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		Date date=new Date();
 		String date1=sdf.format(date).toString();
 		
 		Order order=new Order();
 		order.setOrder_time(date1);
 		order.setOrder_money(money);
 		order.setOrder_discount(1);
 		order.setOrder_end_price(money);
 		order.setFood_count(count);
 		order.setClient_desk_id(deskno);
 		order.setClient_name("上帝");
 		order.setOrder_status(1);
 		order.setEmployee_id(001);
 		order.setClient_name("很勤劳");
 		
 		if(dd.insertOrderByinfo(order)>0){
 			return true;
 		}
 		
		return false;
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
