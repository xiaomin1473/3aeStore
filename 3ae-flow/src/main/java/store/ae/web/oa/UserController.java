package store.ae.web.oa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import store.ae.dto.oa.UserExposer;
import store.ae.dto.oa.UserResult;
import store.ae.pojo.oa.User;
import store.ae.service.oa.UserService;

@Controller
@RequestMapping("/")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list",
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public String categorieList(){
		Long Id =1L;
		
		User user = userService.getUser(Id);
		
		System.out.println(user);
		
		return user.toString();
	}
	
	@RequestMapping(value = "/login", 
			method = RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public UserResult<UserExposer> login(String userName, String userPwd) {
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
