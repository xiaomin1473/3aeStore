package store.ae.api.mall;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import store.ae.dto.mall.feast.Exposer;
import store.ae.dto.mall.feast.SeckillResult;
import store.ae.dto.mall.feast.SeckilllExecution;
import store.ae.enums.mall.feast.SeckillStatEnum;
import store.ae.exception.mall.feast.SeckillCloseException;
import store.ae.exception.mall.feast.SeckillRepeatException;
import store.ae.pojo.mall.feast.Seckill;
import store.ae.service.mall.feast.SeckillService;

@Controller
@RequestMapping("/seckill") // url:/模块/资源/{id}/细分
public class SeckillController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillService seckillService;

	
	@RequestMapping(value = "/list", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Seckill> list() {
		// 获取列表json
		List<Seckill> list = seckillService.getSeckillList();
		
		return list;
	}
	
	@RequestMapping(value = "/{seckillId}/detail",
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public String detail(@PathVariable("seckillId") Long seckillId){
		if(seckillId == null) {
			return "redirect:/mall/seckill/list";
		}
		
		Seckill seckill = seckillService.getById(seckillId);
		if(seckill == null) {
			return "forward:/mall/seckill/list";
		}
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(seckill);
		return jsonString;
	}
	
	// json
	@RequestMapping(value = "/{seckillId}/exposer", 
			method = RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
		SeckillResult<Exposer> result;
		
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			result = new SeckillResult<Exposer>(true, exposer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new SeckillResult<Exposer>(false, e.getMessage());
		}

		return result;
	}
	
	@RequestMapping(value = "/{seckillId}/{md5}/execution", 
			method = RequestMethod.POST,
					produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<SeckilllExecution> execute(
							@PathVariable("seckillId") Long seckillId, 
							@PathVariable("md5") String md5, 
							@CookieValue(value = "killPhone", required = false) Long phone,
							@CookieValue(value = "token", required = true) String token,
							@CookieValue(value = "userName", required = true) String userName) {
		
		// springMVC valid
//		UserExposer userExposer = userService.exportUserToken(userName);
//		
//		if(token == null && userName == null) {
//			return new SeckillResult<SeckilllExecution>(false, "未登录");
//		}
//		if(!token.equals(userExposer.getTocken())) {
//			return new SeckillResult<SeckilllExecution>(false, "用户信息错误，请重新登录");
//		}
		
		try {
			// 存储过程
			SeckilllExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
			
			// 事务回滚
			// SeckilllExecution execution = seckillService.executeSeckill(seckillId, phone, md5);
			return new SeckillResult<SeckilllExecution>(true, execution);
			
		} catch (SeckillRepeatException e) {
			SeckilllExecution execution = new SeckilllExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
			return new SeckillResult<SeckilllExecution>(false, execution);
			
		} catch (SeckillCloseException e) {
			SeckilllExecution execution = new SeckilllExecution(seckillId, SeckillStatEnum.END);
			return new SeckillResult<SeckilllExecution>(false, execution);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			
			SeckilllExecution execution = new SeckilllExecution(seckillId, SeckillStatEnum.INNER_ERROR);
			return new SeckillResult<SeckilllExecution>(false, execution);
		}
	}

	@RequestMapping(value="/time/now", method = RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time() {
		Date now = new Date();
		
		return new SeckillResult<Long>(true, now.getTime());
	}
}
