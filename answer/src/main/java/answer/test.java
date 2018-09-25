package answer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class test {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("处理POST请求…………");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<html><body><h1>测试成功！</h1><i></i><br></body></html>");
	}
}
