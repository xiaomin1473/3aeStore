package blog.userService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class loginCheck {
	public static boolean SSOCheck(HttpServletRequest req) {
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
	}
}
