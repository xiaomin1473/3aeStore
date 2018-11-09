package store.ae.service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class loginService extends HttpServlet {

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
		Boolean result = null;
		
		// 使用模型对账号和密码进行验证，返回一个boolean类型的对象
		if ("xiao" == name && "1234" == pwd) {
			result = true;
		} else {
			result = false;
		}
		
		
		// 判断验证结果并返回
		if(result){  
			response.sendRedirect("success.jsp");
		}
		else {
			response.sendRedirect("fails.jsp");
		}
	}
	
}
