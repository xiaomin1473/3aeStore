package store.ae.dao.mall.goods;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.mall.goods.Brand;
import store.ae.pojo.mall.goods.Category;
import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsDetail;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsImage;
import store.ae.pojo.mall.goods.GoodsSku;


@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({"classpath:store/ae/dao/mall/config/mall-dao.xml"})
public class GoodsDaoTest {
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Test
	public void testQueryAllCategory() {
		
		List<Category> categories = goodsDao.queryAllCategory();

		// logger.info("商品分类如下: \n" + categories);
	}

	@Test
	public void testQueryAllBrand() {
		List<Brand> brands = goodsDao.queryAllBrand();
		
		// logger.info("商品品牌如下: \n" + brands);
	}

	@Test
	public void testQueryAllGoodsByCategory() {
		long categoryType = 1010101;
		int offset = 0;
		int limit = 10;
		
		List<Goods> goods = goodsDao.queryAllGoodsByCategory(categoryType, offset, limit);
		
		// logger.info("根据分类查询商品如下: \n" + goods);
	}

	@Test
	public void testQueryAllGoodsByBrandId() {
		long brandId = 1000L;
		int offset = 0;
		int limit = 10;
		List<Goods> goods = goodsDao.queryAllGoodsByBrandId(brandId, offset, limit);
		
		// logger.info("根据品牌查询商品如下: \n" + goods);
	}

	@Test
	public void testQueryGoodsSpuById() {
		
		long goodsId = 1000L;
		
		Goods goods = goodsDao.queryGoodsSpuById(goodsId);
		
		// logger.info("根据商品ID查询商品SPU如下: \n" + goods);
	}

	@Test
	public void testQueryAllGoodsSkuById() {
		long goodsId = 1000L;
		List<GoodsSku> goodsSkus = goodsDao.queryAllGoodsSkuById(goodsId );
		
		// logger.info("根据商品ID查询商品SKU如下: \n" + goodsSkus);
	}

	@Test
	public void testQueryGoodsDetailById() {
		long goodsId = 1000L;
		GoodsDetail goodsDetail = goodsDao.queryGoodsDetailById(goodsId);
		
		// logger.info("根据商品ID查询商品Detail如下: \n" + goodsDetail);
	}

	@Test
	public void testQueryGoodsImageById() {
		long goodsId = 1000L;
		GoodsImage goodsImage = goodsDao.queryGoodsImageById(goodsId);
		
		// logger.info("根据商品ID查询商品图片如下: \n" + goodsImage);
	}

	@Test
	public void testQueryAllGoodsEvaluatesById() {
		long goodsId = 1000L;
		List<GoodsEvaluate> goodsEvaluates = goodsDao.queryAllGoodsEvaluatesById(goodsId);
		
		// logger.info("根据商品ID查询商品评论如下: \n" + goodsEvaluates);
	}

	@Test
	public void testReduceGoodsStore() {
		long goodsSkuId = 1000L;
		int success = 0;
		
		success = goodsDao.reduceGoodsStore(goodsSkuId);
		
		// logger.info("success is : " + success);
	}
}
