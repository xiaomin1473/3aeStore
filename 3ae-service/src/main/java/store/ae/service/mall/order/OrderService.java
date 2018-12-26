package store.ae.service.mall.order;

import java.util.List;

import store.ae.vo.mall.goods.order.OrderDetailVo;
import store.ae.vo.mall.goods.order.OrderUserVo;

/**
 * @author sidtadpole
 *
 */
public interface OrderService {
	
	/**
	 * 获取用户的订单列表
	 * @return
	 */
	List<OrderUserVo> getUserOrderList(long userId);
	
	/**
	 * 获取订单详情
	 * @return
	 */
	OrderDetailVo getOrderDetail();
}
