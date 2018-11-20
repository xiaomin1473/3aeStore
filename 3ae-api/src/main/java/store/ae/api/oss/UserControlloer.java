package store.ae.api.oss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import store.ae.dao.oss.UserDao;
import store.ae.dto.service.oss.UserExposer;
import store.ae.dto.service.oss.UserResult;
import store.ae.pojo.oss.User;
import store.ae.service.oss.UserService;

@Controller
@RequestMapping("/login") // url:/模块/资源/{id}/细分
public class UserControlloer {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
	public UserResult<UserExposer> login(@PathVariable("userName") String userName, @PathVariable("userPwd") String userPwd) {
		UserResult<UserExposer> result;
		try {
			User user = userService.queryUserByUserName(userName);
			if(user == null) {
				return new UserResult<UserExposer>(false, "用户不存在，请注册");
			}
			
			boolean userInfo = userService.checkUserInfo(userName, userPwd);
			
			if(!userInfo) {
				return new UserResult<UserExposer>(false, "用户名密码错误，请重输");
			}
			
			UserExposer exposer = userService.exportUserToken(userName);
			result = new UserResult<UserExposer>(true, exposer);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			
			return new UserResult<UserExposer>(false, "系统异常");
		}
		
		return result;
	}
}
