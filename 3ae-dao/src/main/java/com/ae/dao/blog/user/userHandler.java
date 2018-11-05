package com.ae.dao.blog.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ae.dao.config.DBUtil;
import com.ae.pojo.blog.user.User;

public class userHandler {
	
	private static Connection blogDB = null;
	
	private static DBUtil conBlog = new DBUtil();
	
	User user = new User();
	
	public static boolean query(String userName, String userPwd) throws SQLException {
		// 连接数据库
		blogDB = conBlog.connetDB(blogDB);
		//创建statement类对象，用来执行SQL语句
		Statement statement = blogDB.createStatement();
		//要执行的SQL语句
		String sql = "select * from user";
		//ResultSet类，用来存放获取的结果集
		ResultSet users = statement.executeQuery(sql);
		System.out.println("-----------------");
		System.out.println("执行结果如下所示:");
		System.out.println("--------------------------------------------------------------");
		System.out.println("用户名" + "\t" + "密码" + "\t" + "用户组" + "\t" + "用户信息" + "\t\t" + "创建时间" + "\t\t\t" + "更新时间");
		System.out.println("--------------------------------------------------------------");
		
		String name = null;
		String pwd = null;
		String userGroup = null;
		String userInfo = null;
		String createTime = null;
		String updateTime = null;
		
		while(users.next()){
			//获取user_uname这列数据
			name = users.getString("user_name");
			//获取user_password这列数据
			pwd = users.getString("user_password");
			userGroup = users.getString("user_group_id");
			userInfo = users.getString("user_info_id");
			createTime = users.getString("create_time");
			updateTime = users.getString("update_time");
			
			
			//输出结果
			System.out.println(name + "\t" + pwd + "\t" + userGroup + "\t" + userInfo + "\t" + createTime + "\t" + updateTime);
			
			if(userName.equals(name) && userPwd.equals(pwd)) {
				return true;
			}
		}
		users.close();
		blogDB.close();

		return false;
	}

}
