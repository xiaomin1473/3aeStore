package store.ae.dao.mall.goods;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.mall.goods.Brand;
import store.ae.pojo.mall.goods.Category;
import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsDetail;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsImage;


@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({"classpath:store/ae/dao/mall/config/mall-dao.xml"})
public class GoodsDaoTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GoodsDao goodsDao;

	
	@Test
	public void testQueryById() {
		long goodsId = 1000L;
		
		Goods iphone = goodsDao.queryById(goodsId);
		
		long brandId = iphone.getBrandId();
		
		logger.info("brands is : " + brandId);
	}
	
	@Test
	public void testQueryBrand() {
		List<Brand> brands = goodsDao.queryBrand();
		
		logger.info("brands is : " + brands);
	}
	
	@Test
	public void testQueryCategory() {
		List<Category> categories = goodsDao.queryCategory();
		
		logger.info("brands is : " + categories);
	}

	@Test
	public void testQueryAllBrand() {
		long brand = 1000L;
		int offset = 0;
		int limit = 1;
		List<Goods> goods = goodsDao.queryAllByBrand(brand, offset, limit);
		
		logger.info("goods is : " + goods);
	}
	
	@Test
	public void testQueryGoodsInfo() {
		long goodsId = 1000;

		GoodsDetail details = goodsDao.queryDetailById(goodsId);
		GoodsImage images = goodsDao.queryImageById(goodsId);
		List<GoodsEvaluate> evaluates = goodsDao.queryEvaluatesById(goodsId);
		
		logger.info("details is : " + details);
		logger.info("images is : " + images);
		logger.info("evaluates is : " + evaluates);
	}

}
