package com.ae.web.blog.userCtrl;

import java.sql.SQLException;
import com.ae.web.database.blog.user.userHandler;

public class Login{

	public static Boolean check(String name, String pwd) {
		Boolean result = false;
		try {
			result = userHandler.query(name, pwd);
			return result;
		} catch (SQLException e) {
		   // out.println("<html><body><h1>loggers</h1><i>" + e + "</i><br></body></html>");
		   return false;
		}
	}	
	
/*	public static boolean Check(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("ssocookie")
						&& cookie.getValue().equals("sso")) {
						return true;
				}
			}
		}
		return false;
	}*/
}
