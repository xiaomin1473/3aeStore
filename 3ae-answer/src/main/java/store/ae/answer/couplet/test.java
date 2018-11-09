package store.ae.answer.couplet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class test extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("处理GET请求…………");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		out.println("<html><body><i>This is a GET request!</i><br><h1>hello servlet</h1></body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("处理POST请求…………");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<html><body><h1>测试成功！</h1><i></i><br></body></html>");
	}
}
