package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Desk;
import com.entity.Foods;
import com.util.DBHelper;

public class deskDAO {
	
	// 获得桌子的所有信息
	public ArrayList<Desk> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Desk> list = new ArrayList<Desk>(); // 商品集合
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from desk;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Desk item = new Desk();
				item.setDesk_id(rs.getInt("desk_id"));
				item.setDesk_name(rs.getString("desk_name"));
				item.setDesk_status(rs.getInt("desk_status"));								
											
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
	
	
	// 根据桌子编号获得桌子全部信息
	public Desk getItemsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from desk where desk_id=?;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Desk item = new Desk();
				item.setDesk_id(rs.getInt("desk_id"));
				item.setDesk_name(rs.getString("desk_name"));
				item.setDesk_status(rs.getInt("desk_status"));								
				return item;
			} else {
				return null;
			}

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
	
	
	
	// 根据id删除桌子信息
	// 返回值int
	public int deleteById(int id) {

		int flag = 0;

		Connection conn = null;
		// 预编译Statement，可以执行带参数的SQL语句
		PreparedStatement pstmt = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "delete from desk where desk_id=?";
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
	
	
	// 修改桌子信息
	// 返回值int
	public int updateFoodInfo(Desk desk) {

		int flag = 0;

		Connection conn = null;
		// 预编译Statement，可以执行带参数的SQL语句
		PreparedStatement pstmt = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "update desk set desk_name=?,desk_status=? where desk_id=?";					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, desk.getDesk_name());
			pstmt.setInt(2, desk.getDesk_status());
			pstmt.setInt(3, desk.getDesk_id());																
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
