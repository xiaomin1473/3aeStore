package com.ae.dao.old;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	public static void main(String[] args) throws SQLException {
		Connection con;
		
		//驱动程序名
		String driver = "com.mysql.cj.jdbc.Driver";
		//URL指向要访问的数据库名rs-h
		String url = "jdbc:mysql://localhost:3306/rs-h?useUnicode=true&characterEncoding=utf8&useSSL=false";
		
		//MySQL配置时的用户名
		String user = "root";
		//MySQL配置时的密码
		String password = "#8086*XiaoMin&1473)";
		
		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(driver);
			
			//getConnection()方法，连接MySQL数据库
			con = DriverManager.getConnection(url,user,password);
			
			if(!con.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			
			//创建statement类对象，用来执行SQL语句
			Statement statement = con.createStatement();
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
			con.close();
			
		} catch (ClassNotFoundException e) {
			//数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace(); 
		} catch(SQLException e) {
			//数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			System.out.println("数据库数据成功连接！！");
		}
		
	}
	
}