package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("处理GET请求…………");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		out.println("<html><body><i>This is a GET request!</i><br><h1>hello servlet</h1></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest requse, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("处理POST请求…………");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		out.println("<html><body><i>This is a POST request!</i><br><h1>hello servlet</h1></body></html>");
	}
	
}
