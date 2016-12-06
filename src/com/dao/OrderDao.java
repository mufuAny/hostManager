package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Foods;
import com.entity.Order;
import com.util.DBHelper;

public class OrderDao {
	// 获得所有的点菜信息
	public ArrayList<Order> getAllOrderList() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<Order>(); // 商品集合
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from orderinfo;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Order item = new Order();
				item.setOrder_id(rs.getInt("order_id"));
				item.setOrder_time(rs.getString("order_time"));
				item.setOrder_money(rs.getString("order_money"));
				item.setOrder_discount(rs.getFloat("order_discount"));
				item.setOrder_end_price(rs.getString("order_end_price"));
				item.setFood_count(rs.getInt("food_count"));
				item.setClient_desk_id(rs.getInt("client_desk_id"));
				item.setClient_name(rs.getString("client_name"));
				item.setOrder_status(rs.getInt("order_status"));
				item.setEmployee_id(rs.getInt("employee_id"));
				item.setEmployee_name(rs.getString("employee_name"));															
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
	
	
	// 根据id删除顾客点菜信息
	// 返回值int
	public int deleteById(int id) {

		int flag = 0;

		Connection conn = null;
		// 预编译Statement，可以执行带参数的SQL语句
		PreparedStatement pstmt = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "delete from orderinfo where order_id=?";
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
}
