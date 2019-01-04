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

import store.ae.common.exception.mall.AbsentException;
import store.ae.dto.mall.goods.ListExposer;
import store.ae.dto.mall.goods.PathExposer;
import store.ae.dto.mall.goods.SingleExposer;
import store.ae.service.mall.order.OrderService;
import store.ae.vo.mall.goods.order.OrderDetailVo;
import store.ae.vo.mall.goods.order.OrderUserVo;

@Controller
@RequestMapping("/order") // url:/模块/资源/{id}/细分
public class OrderController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderService orderService;
	
	private final String ERROR_INFO = "错误信息\n【订单管理】";
	
	@RequestMapping(value = "/list/{userId}", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public ListExposer<OrderUserVo> orderList(@PathVariable("userId") Long userId) {
		ListExposer<OrderUserVo> result;
		
		
		try {
			
			List<OrderUserVo> OrderUserVoList = orderService.getUserOrderList(userId);
			
			result = new ListExposer<OrderUserVo>(0, "查询成功" , OrderUserVoList);
		} catch (AbsentException e) {
			
			logger.error("{} 订单不存在 {}", ERROR_INFO, e.getMessage());
			
			result = new ListExposer<OrderUserVo>(0, "订单不存在");
		}
		catch (Exception e) {
			
			logger.error("{} 系统异常 {}",ERROR_INFO, e.getMessage());
			
			result = new ListExposer<OrderUserVo>(0, "系统异常");
		}
		
		return result;
	}
	
	@RequestMapping(value = "/detail/{orderId}", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public SingleExposer<OrderDetailVo> orderDetail(@PathVariable("orderId") Long orderId) {
		SingleExposer<OrderDetailVo> result;
		
		try {
			
			OrderDetailVo orderDetailVo = orderService.getOrderDetail(orderId);
			
			result = new SingleExposer<OrderDetailVo>(0, "查询成功", orderDetailVo);
		} catch (Exception e) {
			
			logger.error("{} 订单详情查询失败 {}",ERROR_INFO, e.getMessage());
			
			result = new SingleExposer<OrderDetailVo>(-1, "查询失败");
		}
		
		return result;
	}
	
	@RequestMapping(value = "/defray/exposer/{orderId}",
			method = RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public PathExposer getDefrayPath(@PathVariable("orderId") Long orderId) {
		PathExposer result;
		String pathMD5 = null;
		
		try {

			pathMD5 = orderService.getOrderDefrayPath(orderId);

			result = new PathExposer(true, "地址", pathMD5);
		} catch (Exception e) {
			
			logger.error("{} 支付地址生成失败 {}",ERROR_INFO, e.getMessage());
			
			result = new PathExposer(false, "地址生成失败", pathMD5);
		}
		
		return result;
	}
}