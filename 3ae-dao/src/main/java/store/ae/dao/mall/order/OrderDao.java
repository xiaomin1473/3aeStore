package store.ae.dao.mall.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.mall.order.Order;
import store.ae.pojo.mall.order.OrderGoods;
import store.ae.pojo.mall.order.OrderUser;

public interface OrderDao {
	
	/**
	 * 根据订单ID查询订单
	 * @return
	 */
	Order queryOrderByOrderId(@Param("orderId") long orderId);
	
	
	/**
	 * 根据用户ID查询所有订单
	 * @return
	 */
	List<Order> queryOrderAllByUserId(@Param("userId") long userId);
	
	/**
	 * 查询订单收货人
	 * @return
	 */
	OrderUser queryOrderUserByOrderId(@Param("orderId") long orderId);

	/**
	 * 查询订单商品
	 * @return
	 */
	OrderGoods queryOrderGoodsByOrderId(@Param("orderId") long orderId);
}
