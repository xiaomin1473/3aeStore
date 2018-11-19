package store.ae.dao.mall.feast;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.mall.feast.SeckillSuccess;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration({"classpath:store/ae/dao/mall/config/mall-dao.xml"})
public class SeckillSuccessDaoTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 注入Dao实现类依赖
	@Resource
	private SeckillSuccessDao seckillSuccessDao;
	
	@Test
	public void testInsertSeckillSuccess() {
		long id = 1002L;
		long phone = 13544114331L;
		int insertCount = seckillSuccessDao.insertSeckillSuccess(id, phone);
		
		logger.info("insertCount=" + insertCount);
		/*
		* 第一次执行： Updates: 1 insertCount = 1
		* 
		* 第二次执行： Updates: 0 insertCount = 0
		*/
	}

	@Test
	public void testQueryByIdWidthSeckill() throws Exception {
		long id = 1002L;
		long phone = 13544114331L;
		
		SeckillSuccess seckillSuccess = seckillSuccessDao.queryByIdWithSeckill(id, phone);
		
		logger.info("seckillSuccess=" + seckillSuccess);
		logger.info("seckill=" + seckillSuccess.getSeckill());
		/*
		 * 第一次
		 * seckillSuccess = SeckillSuccess [seckillId=1000, 
		 * userPhone=13544114331, 
		 * state=-1, 
		 * gmtCreate=Tue Nov 13 08:51:18 CST 2018]
		 * 
		 * seckill = Seckill [seckillId=1000, 
		 * name=1000元秒杀iphoneX, 
		 * number=100, 
		 * startTime=Sun Nov 11 00:00:00 CST 2018, 
		 * endTime=Mon Nov 12 00:00:00 CST 2018, 
		 * gmtCreate=Fri Nov 09 10:49:13 CST 2018]
		 * 
		 * 第二次
		 * seckillSuccess = SeckillSuccess [seckillId=1001, 
		 * userPhone=13544114331, 
		 * state=0, 
		 * gmtCreate=Tue Nov 13 09:26:27 CST 2018]
		 * 
		 * seckill = Seckill [seckillId=1001, 
		 * name=1500元秒杀iphoneXs, 
		 * number=100, 
		 * startTime=Sun Nov 11 00:00:00 CST 2018, 
		 * endTime=Mon Nov 12 00:00:00 CST 2018, 
		 * gmtCreate=Fri Nov 09 10:49:13 CST 2018]
		 * 
		 */
	}

}
