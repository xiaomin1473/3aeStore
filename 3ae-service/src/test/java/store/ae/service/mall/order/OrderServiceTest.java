package store.ae.service.mall.order;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.vo.mall.goods.order.OrderUserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/mall/config/mall-dao.xml",
	"classpath:store/ae/service/mall/config/mall-service.xml"})
public class OrderServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderService orderService;

	@Test
	public void testGetUserOrderList() {
		Long userId = 1000L;
		
		List<OrderUserVo> orderUserVoList = orderService.getUserOrderList(userId);
		
		logger.info("list is :\n" + orderUserVoList);
	}

	@Test
	public void testGetOrderDetail() {
		fail("Not yet implemented");
	}

}
