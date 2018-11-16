package store.ae.dao.mall.cache;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合, junit启动时加载springIOC容器
 * 
 * @author sidtadpole
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({"classpath:store/ae/dao/mall/config/mall-dao.xml"})

public class RedisDaoTest {

	@Test
	public void testGetSeckill() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutSeckill() {
		fail("Not yet implemented");
	}

}
