package store.ae.api.oss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import store.ae.service.oss.UserService;

@Controller
@RequestMapping("/login") // url:/模块/资源/{id}/细分
public class UserControlloer {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/test", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public String test() {
		return "hello";
	}
	
	@RequestMapping(value = "/{userName}/{userPwd}", 
			method = RequestMethod.POST,
			
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public String check(@PathVariable("userName") String userName, @PathVariable("userPwd") String userPwd) {

		boolean userInfo = userService.checkUserInfo(userName, userPwd);
		
		if(!userInfo) {
			return "登录失败";
		}
		return "登录成功";
	}
}
