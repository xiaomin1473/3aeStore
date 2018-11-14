package store.ae.dao.mall.feast;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.mall.feast.Seckill;


/**
 * 配置spring和junit整合, junit启动时加载springIOC容器
 * 
 * @author sidtadpole
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({"classpath:store/ae/dao/mall/config/mall-dao.xml"})

public class SeckillDaoTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;

	@Test
	public void testReduceNumber() {
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(1000L, killTime);
		logger.info("updateCount={}" + updateCount);
		/*
		 * update feast_seckill set number = number - 1 
		 * where seckill_id = ? 
		 * and start_time <= ? 
		 * and end_time >= ? 
		 * and number > 0; 
		 * 
		 * 1000(Long), 
		 * 2018-11-12 18:53:56.102(Timestamp), 
		 * 2018-11-12 18:53:56.102(Timestamp)
		 * Updates: 0
		 */
	}

	@Test
	public void testQueryById() {
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		logger.info("seckillName={}", seckill.getName());
		logger.info("seckill={}",seckill);
		/*  1000元秒杀iphoneX
		*   Seckill [seckillId=1000, 
		*	name=1000元秒杀iphoneX, 
		*	number=100, 
		*	startTime=Sun Nov 11 00:00:00 CST 2018, 
		*	endTime=Mon Nov 12 00:00:00 CST 2018, 
		*	gmtCreate=Fri Nov 09 10:49:13 CST 2018]
		*/
	}

	@Test
	// List<Seckill> queryAll(int offet, int limit);
	// java没有保存形参的记录 queryAll(int offet, int limit) => queryAll(arg0, arg1)
	// 
	public void testQueryAll() {
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		for(Seckill seckill: seckills) {
			logger.info("seckill={}", seckill);
		}
	}

}
