package store.ae.service.mall.goods;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import store.ae.pojo.mall.goods.Goods;
import store.ae.vo.mall.goods.category.CategoryVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/mall/config/mall-dao.xml",
	"classpath:store/ae/service/mall/config/mall-service.xml"})
public class GoodsServiceTest {
	
	@Autowired
	private GoodsService goodsService;

	@Test
	public void testGetCategoryList() {
		List<CategoryVo> categories = goodsService.getCategoryList();
		
		Assert.assertTrue(categories != null);
	}

	@Test
	public void testGetGoodsListByCategory() {
		long categoryType = 1010101;
		int offset = 0;
		int limit = 10;
		List<Goods> goods = goodsService.getGoodsListByCategory(categoryType, offset, limit);

		Assert.assertTrue(goods != null);
	}

	@Test
	public void testGetBrandList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGoodsListByBrandId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGoodsList() {
		// 数据库连接池配置
		JedisPoolConfig config = new JedisPoolConfig();
		
		// 设置最大连接数
		config.setMaxTotal(30);
		
		// 设置最大空闲连接数
		config.setMaxIdle(10);
		
		JedisPool jedisPool = new JedisPool(config, "3ae.store", 56379);
		
		// 保存
		Jedis jedis = null;
		
		try {
			jedis = jedisPool.getResource();
			
			// 设置数据
			jedis.set("name2", "张三到此一游！");
			
			String value = jedis.get("name");
			String value2 = jedis.get("name2");
			
			System.out.println(value);
			System.out.println(value2);
			
			Assert.assertTrue(value != null);
		} catch (Exception e) {
			
		} finally {
			// 释放资源
			if(jedis != null) {
				jedis.close();
			}
			if(jedisPool != null) {
				jedisPool.close();
			}
		}
	}

	@Test
	public void testGetGoodsDetailById() {
		
	}

	@Test
	public void testGetAllGoodsSkuById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGoodsSkuById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGoodsEvaluateById() {
		fail("Not yet implemented");
	}

}
