package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sun.jdbc.odbc.OdbcDef;

import com.entity.Employees;
import com.entity.Foods;
import com.entity.Order;
import com.util.DBHelper;

public class FoodsDAO {
	// 获得所有的商品信息
	public ArrayList<Foods> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Foods> list = new ArrayList<Foods>(); // 商品集合
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from foods;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Foods item = new Foods();
				item.setFood_id(rs.getInt("food_id"));
				item.setFood_name(rs.getString("food_name"));
				item.setFood_classify(rs.getString("food_classify"));
				item.setFood_price(rs.getInt("food_price"));
				item.setFood_declare(rs.getString("food_declare"));
				item.setFood_picture(rs.getString("food_picture"));
											
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

	// 根据商品编号获得商品资料
	public Foods getItemsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from foods where food_id=?;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Foods item = new Foods();
				
				item.setFood_id(rs.getInt("food_id"));
				item.setFood_name(rs.getString("food_name"));
				item.setFood_classify(rs.getString("food_classify"));
				item.setFood_price(rs.getInt("food_price"));
				item.setFood_declare(rs.getString("food_declare"));
				item.setFood_picture(rs.getString("food_picture"));
												
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
	//获取最近浏览的前五条商品信息
	public ArrayList<Foods> getViewList(String list)
	{
		System.out.println("list:"+list);
		ArrayList<Foods> itemlist = new ArrayList<Foods>();
		int iCount=5; //每次返回前五条记录
		if(list!=null&&list.length()>0)
		{
		    String[] arr = list.split(",");
		    System.out.println("arr.length="+arr.length);
		    //如果商品记录大于等于5条
		    if(arr.length>=5)
		    {
		       for(int i=arr.length-1;i>=arr.length-iCount;i--)
		       {
		    	  itemlist.add(getItemsById(Integer.parseInt(arr[i])));  
		       }
		    }
		    else
		    {
		    	for(int i=arr.length-1;i>=0;i--)
		    	{
		    		itemlist.add(getItemsById(Integer.parseInt(arr[i])));
		    	}
		    }
		    return itemlist;
		}
		else
		{
			return null;
		}
		
	}
	
	// 录入顾客点菜信息
	// 返回值int
	public int insertOrderByinfo(Order order) {

		int flag = 0;

		Connection conn = null;
		// 预编译Statement，可以执行带参数的SQL语句
		PreparedStatement pstmt = null;

		try {
			conn = DBHelper.getConnection();
			String sql="insert into order " +
					"(order_time,order_money,order_end_price,food_count," +
					"client_desk_id,client_name,order_status,employee_id,employee_name)" +
					" values(?,?,?,?,?,?,?,?,?)";			
			
			String sql1="INSERT INTO orderinfo (order_time,order_money,order_discount,order_end_price,food_count,client_desk_id,client_name,order_status,employee_id,employee_name) VALUES(?,?,?,?,?,?,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql1);			
			pstmt.setString(1, order.getOrder_time());
			pstmt.setString(2, order.getOrder_money());
			pstmt.setFloat(3, order.getOrder_discount());
			pstmt.setString(4, order.getOrder_end_price());
			pstmt.setInt(5, order.getFood_count());
			pstmt.setInt(6, order.getClient_desk_id());
			pstmt.setString(7, order.getClient_name());
			pstmt.setInt(8, order.getOrder_status());
			pstmt.setInt(9, order.getEmployee_id());
			pstmt.setString(10, order.getEmployee_name());

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
	
	
	
	// 根据id菜品信息
	// 返回值int
	public int deleteById(int id) {

		int flag = 0;

		Connection conn = null;
		// 预编译Statement，可以执行带参数的SQL语句
		PreparedStatement pstmt = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "delete from foods where food_id=?";
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
	
	
	// 修改菜品信息
	// 返回值int
	public int updateFoodInfo(Foods foods) {

		int flag = 0;

		Connection conn = null;
		// 预编译Statement，可以执行带参数的SQL语句
		PreparedStatement pstmt = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "update foods set food_name=?,food_classify=?" +
					",food_price=?,food_declare=?,food_picture=? where food_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, foods.getFood_name());
			pstmt.setString(2, foods.getFood_classify());
			pstmt.setInt(3, foods.getFood_price());
			pstmt.setString(4, foods.getFood_declare());
			pstmt.setString(5, foods.getFood_picture());
			pstmt.setInt(6, foods.getFood_id());			
						
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
