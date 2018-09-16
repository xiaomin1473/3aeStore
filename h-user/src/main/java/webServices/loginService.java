package webServices;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.userService.login;
import blog.userService.loginCheck;

public class loginService extends login{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@SuppressWarnings("null")
	public void loginCheck() throws IOException {
		HttpServletRequest req = null;
		HttpServletResponse res = null;
		res.setContentType("text/html;charset=UTF-8");
		
		if(loginCheck.SSOCheck(req)) {
			res.sendRedirect("/h-web/");
		}
		else {
			res.sendRedirect("/login.jsp");
		}
	}
	
}