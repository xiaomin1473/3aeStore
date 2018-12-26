package store.ae.api.mall;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import store.ae.dto.mall.goods.OrderUserExposer;
import store.ae.service.mall.order.OrderService;
import store.ae.vo.mall.goods.order.OrderUserVo;

@Controller
@RequestMapping("/order") // url:/模块/资源/{id}/细分
public class OrderController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/{userId}/list", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public OrderUserExposer orderList(@PathVariable("userId") Long userId) {
		OrderUserExposer result;
		
		List<OrderUserVo> OrderUserVoList = orderService.getUserOrderList(userId);
		
		try {
			
			result = new OrderUserExposer(0, "查询成功" , OrderUserVoList);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("【订单管理】订单查询失败" + e.getMessage());
			
			result = new OrderUserExposer(0, "查询失败");
		}
		
		return result;
	}

}
