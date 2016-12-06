package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoodsDAO;
import com.entity.Foods;

public class foodManager extends HttpServlet {

	private String action ; //表示购物车的动作 ,add,show,delete
	private	FoodsDAO foodDao=new FoodsDAO();	
	/**
	 * Constructor of the object.
	 */
	public foodManager() {
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

	//删除菜品信息
	private boolean foodsManagerDelect(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int kaiguan=foodDao.deleteById(Integer.parseInt(id));
		if(kaiguan>0){
			return true;
		}
		return false;		
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
			if(action.equals("delete")){
				if(foodsManagerDelect(request,response))
				{
					request.getRequestDispatcher("/foods.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/foods.jsp").forward(request, response);
				}
			}
			
			if(action.equals("update")){
				if(foodsManagerUpdate(request,response))
				{
					request.getRequestDispatcher("/foods.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/foods.jsp").forward(request, response);
				}
			}
			
			
		}
	}

	//更新菜谱信息
	private boolean foodsManagerUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("food_id"));
		String food_name=request.getParameter("food_name");
		String food_classify=request.getParameter("food_classify");
		int food_price=Integer.parseInt(request.getParameter("food_price"));
		String food_declare=request.getParameter("food_declare");
		String food_picture=request.getParameter("food_picture");
		
		Foods food=new Foods();
		food.setFood_id(id);
		food.setFood_name(food_name);
		food.setFood_classify(food_classify);
		food.setFood_price(food_price);
		food.setFood_declare(food_declare);
		food.setFood_picture(food_picture);
		int end=foodDao.updateFoodInfo(food);
		if(end>0){
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
