package store.ae.service.mall.feast;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.common.exception.mall.CloseException;
import store.ae.dto.mall.feast.Exposer;
import store.ae.dto.mall.feast.SeckilllExecution;
import store.ae.pojo.mall.feast.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/mall/config/mall-dao.xml",
	"classpath:store/ae/service/mall/config/mall-service.xml"})
public class SeckillServiceTest {
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillList() throws Exception {
		List<Seckill> list = seckillService.getSeckillList();
		
		Assert.assertTrue(list != null);
		
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

		Assert.assertTrue(seckill != null);
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
			Assert.assertTrue(exposer != null);
			
			long phone = 13544364323L;
			String md5= exposer.getMd5();
			try {
				SeckilllExecution execution = seckillService.executeSeckill(id, phone, md5);
				Assert.assertTrue(execution != null);
			} catch (CloseException e) {
			}
		} else {
			// 秒杀未开启
			Assert.assertTrue(exposer != null);
		}
	}
	
	@Test
	public void executeSeckillProcedure() {
		long seckillId = 1002L;
		long phone = 13244438832L;
		
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		Assert.assertTrue(exposer != null);
		
		if(exposer.isExposed()) {
			String md5 = exposer.getMd5();
			Assert.assertTrue(md5 != null);
			SeckilllExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);

			Assert.assertTrue(execution != null);
		} else {
			Assert.assertTrue(exposer != null);
		}
	}
}
