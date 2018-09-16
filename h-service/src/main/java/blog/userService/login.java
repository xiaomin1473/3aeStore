package blog.userService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.user.dao.userHandler;

public class login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("处理GET请求…………");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		out.println("<html><body><i>This is a GET request!</i><br><h1>hello servlet</h1></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("处理POST请求…………");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Boolean result = true;
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			result = userHandler.query(name, pwd);
			
			out.println("<html><body><i>This is " + result + " request!</i><br><h1>hello servlet</h1></body></html>");
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("<html><body><i>This is " + "error!" + " request!</i><br><h1>hello servlet</h1></body></html>");
			
		}
		
		// 判断验证结果并返回
//		if(result){
//			response.sendRedirect("success.jsp");
//		}
//		else {
//			response.sendRedirect("fails.jsp");
//		}
		
	}
}
