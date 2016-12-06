package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Desk;
import com.entity.Employees;
import com.util.DBHelper;

public class employeeDAO {
	
	// 获得所有的商品信息
	public ArrayList<Employees> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Employees> list = new ArrayList<Employees>(); // 商品集合
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from employees;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Employees item = new Employees();
				item.setEmployee_id(rs.getInt("employee_id"));
				item.setEmployee_login_id(rs.getString("employee_login_id"));
				item.setEmployee_login_password(rs.getString("employee_login_password"));
				item.setEmployee_name(rs.getString("employee_name"));
				item.setEmployee_role(rs.getString("employee_role"));											
											
				list.add(item);// 把一个商品加入集合
			}
			return list; // 返回集合。
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}
	
	/*public Employees emplManagerShow(Connection con, String dormManagerId)throws Exception {
		String sql = "select * from employees t1 where t1.employee_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, dormManagerId);
		ResultSet rs=pstmt.executeQuery();
		Employees employees = new Employees();
		if(rs.next()) {
			employees.setEmployee_id(rs.getInt("employee_id"));
			employees.setEmployee_login_id(rs.getString("employee_login_id"));
			employees.setEmployee_login_password(rs.getString("employee_login_password"));
			employees.setEmployee_name(rs.getString("employee_name"));
			employees.setEmployee_role(rs.getString("employee_role"));
						
		}
		return employees;
	}*/
	
	// 根据id删除学生信息
	// 返回值int
	public int deleteById(int id) {

		int flag = 0;

		Connection conn = null;
		// 预编译Statement，可以执行带参数的SQL语句
		PreparedStatement pstmt = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "delete from employees where employee_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			flag = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 注意：更新操作不会用到ResultSet对象。
			// 但是closeAll方法要求该参数，用null就可以了。
				
		}

		return flag;

	}
	
	// 根据id查询学生信息
	// 查到了，返回学生对象，反之，返回null
	public Employees findById(int id) {

		// return语句中将要返回的学生对象
		Employees now = null;

		Connection conn = null;
		ResultSet rs = null;
		// 预编译Statement，可以执行带参数的SQL语句
		PreparedStatement pstmt = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "select * from employees where employee_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			// 因为id是主键，查询结果要么1条，要么0条。
			// 所以，这里不用while循环
			if (rs.next()) {

				// 一定要实例化，否则后面的语句会出现空指针异常
				now = new Employees();

				// 使用字段值组装出来一个Student对象（数据封装）	
				now.setEmployee_id(rs.getInt("employee_id"));
				now.setEmployee_login_id(rs.getString("employee_login_id"));
				now.setEmployee_login_password(rs.getString("employee_login_password"));
				now.setEmployee_name(rs.getString("employee_name"));
				now.setEmployee_role(rs.getString("employee_role"));				
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		/*finally {
			DBHelper.closeAll(conn, pstmt, rs);
		}*/
		// 返回学生对象
		return now;
	}
	
	// 根据更新员工信息
	// 返回值int
	public int updateByinfo(Employees employees) {

		int flag = 0;

		Connection conn = null;
		// 预编译Statement，可以执行带参数的SQL语句
		PreparedStatement pstmt = null;

		try {
			conn = DBHelper.getConnection();
			String sql="update employees set employee_name=?,employee_login_id=?," +
					"employee_login_password=?,employee_role=? where employee_id=?";			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, employees.getEmployee_name());
			pstmt.setString(2, employees.getEmployee_login_id());
			pstmt.setString(3, employees.getEmployee_login_password());
			pstmt.setString(4, employees.getEmployee_role());
			pstmt.setInt(5, employees.getEmployee_id());

			flag = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		/*finally {
			// 注意：更新操作不会用到ResultSet对象。
			// 但是closeAll方法要求该参数，用null就可以了。
			DBHelper.closeAll(conn, pstmt, null);			
		}*/

		return flag;

	}
}
