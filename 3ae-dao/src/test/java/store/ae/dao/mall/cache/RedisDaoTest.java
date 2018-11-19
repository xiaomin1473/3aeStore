package store.ae.dao.mall.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import store.ae.dao.mall.feast.SeckillDao;
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

public class RedisDaoTest {
	private int id = 1002;

	@Autowired
	private RedisDao redisDao;
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Test
	public void testRedis() {
		JedisPool jedisPool = new JedisPool("3ae.store", 6379);
		System.out.println("connection: " + jedisPool.toString());
		Jedis jedis = jedisPool.getResource();
		if(jedis == null) {
			System.out.println("连接失败");
		}
		if(jedis.get("test") == null) {
			jedis.set("test", "hello jedis!");
			System.out.println("set success!");
		} else {
			String test = jedis.get("test");
			System.out.println("redis says: " + test);
		}
		jedisPool.close();
	}
	
	@Test
	public void testSeckill() throws Exception {
		//get and put
		Seckill seckill =  redisDao.getSeckill(id);
		if(seckill == null) {
			seckill = seckillDao.queryById(id);
			System.out.println(seckill);
			if(seckill != null) {
				String result = redisDao.putSeckill(seckill);
				System.out.println(result);
				seckill = redisDao.getSeckill(id);
				System.out.println(seckill);
			}
		}
		System.out.println("redis get = " + seckill);
	}

	@Test
	public void testPutSeckill() {
		
	}

}
