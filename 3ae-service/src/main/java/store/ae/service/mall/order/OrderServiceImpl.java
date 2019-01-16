package store.ae.service.mall.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import store.ae.common.exception.mall.AbsentException;
import store.ae.dao.mall.order.OrderDao;
import store.ae.pojo.mall.order.Order;
import store.ae.pojo.mall.order.OrderBuyer;
import store.ae.pojo.mall.order.OrderGoods;
import store.ae.vo.mall.goods.order.OrderDetailVo;
import store.ae.vo.mall.goods.order.OrderUserVo;

/**
 * @author sidtadpole
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	private final String ERROR_INFO = "\n【订单服务】";
	
	// md5盐值字符串，用来混淆md5
	private final String slat = "aFO*Ht*aMF#48_5GA(mf-g1a_G$PIT5*Aa^p1%@HW+_ijfo&-i14#Yg%er#HL=wr15a^sfaw6";
	
	private String getMD5(long orderId) {
		String base = orderId +"/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		
		return md5;
	}
	
	private void isNull(Order order) {
		if(order == null) { throw new AbsentException(ERROR_INFO + "订单不存在");}
	}
	
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
	public OrderDetailVo getOrderDetail(long orderId) throws AbsentException {
		OrderDetailVo orderDetailVo = new OrderDetailVo();
		
		Order order = orderDao.queryOrderByOrderId(orderId);
		
		isNull(order);
		
		OrderGoods orderGoods = orderDao.queryOrderGoodsByOrderId(orderId);
		OrderBuyer orderBuyer = orderDao.queryOrderBuyerByOrderId(orderId);
		
		orderDetailVo.setOrderId(orderId);
		orderDetailVo.setCategoryType(order.getCategoryType());
		orderDetailVo.setUserId(order.getUserId());
		orderDetailVo.setUserName(orderBuyer.getUserName());
		orderDetailVo.setLogisticsId(order.getLogisticsId());
		orderDetailVo.setGoodsSkuId(orderGoods.getGoodsSkuId());
		orderDetailVo.setGoodsName(orderGoods.getGoodsName());
		orderDetailVo.setGoodsNumber(orderGoods.getGoodsNumber());
		orderDetailVo.setUnit(orderGoods.getUnit());
		orderDetailVo.setSkuPrice(orderGoods.getSkuPrice());
		orderDetailVo.setMoneyUnit("￥");
		orderDetailVo.setImgUrl(orderGoods.getImgUrl());
		orderDetailVo.setDiscount(order.getDiscount());
		orderDetailVo.setDiscountWay(order.getDiscountWay());
		orderDetailVo.setPayment(order.getPayment());
		orderDetailVo.setOrderStatus(order.getOrderStatus());
		orderDetailVo.setAfterSaleStatus(order.getAfterSaleStatus());
		orderDetailVo.setInvoice(order.getInvoice());
		orderDetailVo.setBuyerName(orderBuyer.getBuyerName());
		orderDetailVo.setBuyerPhone(orderBuyer.getBuyerPhone());
		orderDetailVo.setBuyerAddress(orderBuyer.getBuyerAddress());
		orderDetailVo.setGmtCreate(order.getGmtCreate());
		
		return orderDetailVo;
	}

	@Override
	public String getOrderDefrayPath(long orderId) throws AbsentException {
		
		Order order = orderDao.queryOrderByOrderId(orderId);
		
		isNull(order);
		
		String pathMD5 = getMD5(orderId);
		
		return pathMD5;
	}
}


