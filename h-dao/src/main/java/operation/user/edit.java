package operation.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
public class edit {
	
	public static void main(String[] args) throws SQLException, ParseException {
		Connection con = null;
		
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
				
				//要执行的SQL语句

				PreparedStatement psql;
				psql = con.prepareStatement("update user set user_password = ? where user_name = ?");

				psql.setString(1, "1234");
				psql.setString(2, "xiao");
			
				psql.executeUpdate();           //执行更新
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
			System.out.println("数据User成功编辑！");
		}
	}	
	
}
