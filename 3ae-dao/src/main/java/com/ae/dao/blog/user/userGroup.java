package com.ae.dao.blog.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ae.dao.config.DBUtil;

public class userGroup {
	static Connection blogDB = null;
	
	static DBUtil conBlog = new DBUtil();
	
	public static void query() throws SQLException {
		// 连接数据库
		blogDB = conBlog.connetDB(blogDB);
		//创建statement类对象，用来执行SQL语句
		Statement statement = blogDB.createStatement();
		//要执行的SQL语句
		String sql = "select * from user";
		//ResultSet类，用来存放获取的结果集
		ResultSet rs = statement.executeQuery(sql);
		System.out.println("-----------------");
		System.out.println("执行结果如下所示:");
		System.out.println("--------------------------------------------------------------");
		System.out.println("用户名" + "\t" + "密码" + "\t\t" + "创建时间" + "\t\t\t" + "更新时间");
		System.out.println("--------------------------------------------------------------");
		
		String name = null;
		String pwd = null;
		String createTime = null;
		String updateTime = null;
		
		while(rs.next()){
			//获取user_uname这列数据
			name = rs.getString("user_name");
			//获取user_password这列数据
			pwd = rs.getString("user_password");
			createTime = rs.getString("create_time");
			updateTime = rs.getString("update_time");
			
			//输出结果
			System.out.println(name + "\t" + pwd + "\t" + createTime + "\t" + updateTime);
		}
		rs.close();
		blogDB.close();
	}
	
	public static void main(String[] args) {
		try {
			query();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
