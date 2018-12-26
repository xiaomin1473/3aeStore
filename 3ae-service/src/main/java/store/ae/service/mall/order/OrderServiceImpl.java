package store.ae.service.mall.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.ae.dao.mall.order.OrderDao;
import store.ae.pojo.mall.order.Order;
import store.ae.vo.mall.goods.order.OrderDetailVo;
import store.ae.vo.mall.goods.order.OrderUserVo;

/**
 * @author sidtadpole
 *
 */
@Service
public class OrderServiceImpl  implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	/**
	 * 获取用户的订单列表
	 * @return
	 */
	public List<OrderUserVo> getUserOrderList(long userId) {
		List<Order> orderList = orderDao.queryOrderAllByUserId(userId);
		
		List<OrderUserVo> orderUserVoList = new ArrayList<>();

			for(Order order: orderList) {
				OrderUserVo orderUserVo = new OrderUserVo();
				BeanUtils.copyProperties(order, orderUserVo);
				
				orderUserVoList.add(orderUserVo);
			}
		
		return orderUserVoList;
	}
	
	/**
	 * 获取订单详情
	 * @return
	 */
	public OrderDetailVo getOrderDetail() {
		return null;
	}
}
