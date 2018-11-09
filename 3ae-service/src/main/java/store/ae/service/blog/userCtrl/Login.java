package store.ae.service.blog.userCtrl;

import java.sql.SQLException;

import store.ae.dao.old.userHandler;

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
