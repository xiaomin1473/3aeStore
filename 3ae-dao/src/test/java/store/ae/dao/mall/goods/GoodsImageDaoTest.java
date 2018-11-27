package store.ae.dao.mall.goods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsImage;


@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({"classpath:store/ae/dao/mall/config/mall-dao.xml"})
public class GoodsImageDaoTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GoodsDao goodsDao;
	
	@Autowired
	GoodsImageDao goodsImageDao;
	
	@Test
	public void testQueryById() {
		long goodsId = 1000L;
		Goods iphone = goodsDao.queryById(goodsId);
		
		GoodsImage iphoneImage = goodsImageDao.queryById(goodsId);
		
		logger.info("goods is : " + iphone);
		logger.info("goodsImage is : " + iphoneImage);
	}
	
}
