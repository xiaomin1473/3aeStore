package webServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.user.dao.userHandler;
import blog.userService.Login;

public class loginService extends Login{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("处理POST请求…………");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Boolean result = true;
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			result = userHandler.query(name, pwd);
			
		} catch (SQLException e) {
			out.println("<html><body><h1>loggers</h1><i>" + e + "</i><br></body></html>");
			
		}
		
		// 判断验证结果并返回
		if(result){
			HttpSession session = request.getSession();
			
			session.setAttribute("userName", name);
			// 304重定向
			// response.sendRedirect("success.jsp");
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
		else {
			// response.sendRedirect("fails.jsp");
			request.getRequestDispatcher("/fails.jsp").forward(request, response);
		}
		
	}
}