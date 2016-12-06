package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.deskDAO;
import com.entity.Desk;

public class DeskServlet extends HttpServlet {

	
	private String action="" ; //表示购物车的动作 ,add,show,delete
	deskDAO deskDAO=new deskDAO();
	public DeskServlet() {
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
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String deskno=request.getParameter("deskid");		
		request.getSession().setAttribute("deskid", deskno);
		
		if(request.getParameter("action")!=null)
		{
			this.action=request.getParameter("action");
			out.print(action);
			if(action.equals("delete")){
				if(deskManagerDelect(request,response))
				{
					request.getRequestDispatcher("/deskManager.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/deskManager.jsp").forward(request, response);
				}
			}
			
			if(action.equals("show")){
				if(request.getParameter("deskid")!=null){
					int deskid=Integer.parseInt(request.getParameter("deskid"));
					request.getSession().setAttribute("deskno", deskid);
				}else{
					request.getRequestDispatcher("deskManager.jsp").forward(request, response);
				}
			}
			
			if(action.equals("update")){
				if(desksManagerUpdate(request,response))
				{
					request.getRequestDispatcher("/deskManager.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/deskManager.jsp").forward(request, response);
				}
			}						
		}				
	}

	//桌子信息更新
	private boolean desksManagerUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		
		int id=Integer.parseInt(request.getParameter("desk_id"));
		String desk_name=request.getParameter("desk_name");		
		int desk_status=Integer.parseInt(request.getParameter("desk_status"));				
		
		Desk desk=new Desk();
		desk.setDesk_id(id);
		desk.setDesk_name(desk_name);
		desk.setDesk_status(desk_status);		
		int end=deskDAO.updateFoodInfo(desk);
		if(end>0){
			return true;
		}		
		return false;
	}

	//桌子信息删除
	private boolean deskManagerDelect(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int kaiguan=deskDAO.deleteById(Integer.parseInt(id));
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
