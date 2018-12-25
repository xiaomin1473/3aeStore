package store.ae.api.system;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import store.ae.dto.mall.feast.SeckillResult;


@Controller
@RequestMapping("/")
public class SystemController {
	

	@RequestMapping(value="/time/now", method = RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time() {
		Date now = new Date();
		
		return new SeckillResult<Long>(true, now.getTime());
	}
}
