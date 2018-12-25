package store.ae.service.mall.feast;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.dto.mall.feast.Exposer;
import store.ae.dto.mall.feast.SeckilllExecution;
import store.ae.exception.mall.feast.SeckillCloseException;
import store.ae.exception.mall.feast.SeckillRepeatException;
import store.ae.pojo.mall.feast.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/mall/config/mall-dao.xml",
	"classpath:store/ae/service/mall/config/mall-service.xml"})
public class SeckillServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillList() throws Exception {
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}", list);
		
		/*
		* DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@11bb571c]
		* DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2bb3058]
		* 
		* Total: 3
		* 
		*/
		
	}

	@Test
	public void testGetById() throws Exception {
		long id = 1002L;
		Seckill seckill = seckillService.getById(id);
		logger.info("Seckill={}", seckill);
		/*
		 * Seckill=Seckill [seckillId=1001, 
		 * name=1500元秒杀iphoneXs, 
		 * number=100, 
		 * startTime=Sun Nov 11 00:00:00 CST 2018, 
		 * endTime=Mon Nov 13 00:00:00 CST 2018, 
		 * gmtCreate=Fri Nov 09 10:49:13 CST 2018]
		 * 
		 */
	}
	
	// 集成测试代码完整逻辑，注意可重复执行
	@Test
	public void testSeckillLogic() throws Exception{
		long id = 1002L;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		if(exposer.isExposed()) {
			logger.info("exposer={}", exposer);
			
			long phone = 13544364323L;
			String md5= exposer.getMd5();
			try {
				SeckilllExecution execution = seckillService.executeSeckill(id, phone, md5);
				logger.info("reslut={}", execution);
			} catch (SeckillRepeatException e) {
				logger.error(e.getMessage());
			} catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}
		} else {
			// 秒杀未开启
			logger.warn("exposer={}", exposer);
		}
	}
	
	@Test
	public void executeSeckillProcedure() {
		long seckillId = 1002L;
		long phone = 13244438832L;
		
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		logger.info(exposer.toString());
		
		if(exposer.isExposed()) {
			String md5 = exposer.getMd5();
			logger.info(md5);
			SeckilllExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
			logger.info(execution.getStateInfo());
		} else {
			logger.info("秒杀结束");
		}
	}
}
