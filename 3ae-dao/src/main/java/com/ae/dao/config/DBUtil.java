package com.ae.dao.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	@SuppressWarnings("finally")
	public Connection connetDB(Connection con) {
		
		DBConfig mysql = new DBConfig();
		
		//驱动程序名
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//URL指向要访问的数据库名
		String DB  = mysql.DBUtil + ':' +
					 mysql.DB + "://"	+
					 mysql.address + ':' +
					 mysql.port + '/' +
					 mysql.DBName + '?' +
					 "useUnicode=true" + '&' +
					 "characterEncoding=utf8" + '&' +
					 "useSSL=false";
		System.out.println(DB);
		
		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(driver);
			
			//getConnection()方法，连接MySQL数据库
			con = DriverManager.getConnection(DB,mysql.User,mysql.Pwd);
			
			if(!con.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			
			System.out.println("连接成功~");
			
			return con;
			
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
			return con;
		}
			
	}
}
