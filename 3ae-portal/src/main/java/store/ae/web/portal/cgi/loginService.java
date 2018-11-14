/*package store.ae.web.portal.cgi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.ae.service.blog.userCtrl.Login;

public class loginService extends HttpServlet {
	
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("处理POST请求…………");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Boolean result = true;
		
		result = Login.check(name, pwd);
		
		
		// 判断验证结果并返回
		if(result){
			HttpSession session = request.getSession();
			
			session.setAttribute("userName", name);
			// 304重定向
			// response.sendRedirect("success.jsp");
			request.getRequestDispatcher("/views/success.jsp").forward(request, response);
		}
		else {
			// response.sendRedirect("fails.jsp");
			request.getRequestDispatcher("/views/fails.jsp").forward(request, response);
		}
		
	}
}*/