package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.employeeDAO;
import com.entity.Employees;
import com.util.DBHelper;

public class employeeServlet extends HttpServlet {

	private String action ; //表示购物车的动作 ,add,show,delete
	private employeeDAO employeeDAO=new employeeDAO();	
	
	/**
	 * Constructor of the object.
	 */
	public employeeServlet() {
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
			if(action.equals("delete")){
				if(employeesManagerDelect(request,response))
				{
					request.getRequestDispatcher("/employee.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/employee.jsp").forward(request, response);
				}
			}
			
			if(action.equals("update")){
				if(employeesManagerUpdate(request,response)){
					request.getRequestDispatcher("/employee.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/employee.jsp").forward(request, response);
				}
			}
			
		}							
	}

	private boolean employeesManagerUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Employees empl=new Employees();
		
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String employee_login_name=request.getParameter("employee_login_name");
		String employee_login_id=request.getParameter("employee_login_id");
		String employee_login_password=request.getParameter("employee_login_password");		
		String employee_login_role=request.getParameter("employee_login_role");	
		
		empl.setEmployee_id(employee_id);
		empl.setEmployee_login_id(employee_login_id);
		empl.setEmployee_login_password(employee_login_password);
		empl.setEmployee_name(employee_login_name);
		empl.setEmployee_role(employee_login_role);
		
		int kaiguan=employeeDAO.updateByinfo(empl);
		if(kaiguan>0){
			return true;
		}
		return false;
	}

	//删除员工
	private boolean employeesManagerDelect(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
			String id = request.getParameter("id");
			int kaiguan=employeeDAO.deleteById(Integer.parseInt(id));
			if(kaiguan>0){
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
