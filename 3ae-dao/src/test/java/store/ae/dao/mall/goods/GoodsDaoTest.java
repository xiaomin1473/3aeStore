package store.ae.dao.mall.goods;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsDetail;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsImage;
import store.ae.pojo.mall.goods.GoodsType;


@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({"classpath:store/ae/dao/mall/config/mall-dao.xml"})
public class GoodsDaoTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GoodsDao goodsDao;
	
	@Autowired
	GoodsTypeDao goodsTypeDao;
	
	@Autowired
	GoodsImageDao goodsImageDao;
	
	@Autowired
	GoodsDetailDao goodsDetailDao;
	
	@Autowired
	GoodsEvaluateDao goodsEvaluateDao;
	
	@Test
	public void testQueryById() {
		long goodsId = 1000L;
		
		Goods iphone = goodsDao.queryById(goodsId);
		
		long goodsTypeId = iphone.getGoodsTypeId();
		
		GoodsImage iphoneImage = goodsImageDao.queryById(goodsId);
		
		GoodsType iphoneType = goodsTypeDao.queryById(goodsTypeId);

		GoodsDetail iphoneDetail = goodsDetailDao.queryById(goodsId);

		List<GoodsEvaluate> iphoneEvaluate = goodsEvaluateDao.queryById(goodsId);

		logger.info("goods is : " + iphone);
		logger.info("goodsImage is : " + iphoneImage);
		logger.info("goodsType is : " + iphoneType);
		logger.info("goodsDetail is : " + iphoneDetail);
		logger.info("goodsEvaluate is : " + iphoneEvaluate);
	}

	@Test
	public void testQueryAll() {
		int offset = 0;
		int limit = 10;
		List<Goods> goods = goodsDao.queryAll(offset, limit);
		
		logger.info("goods is : " + goods);
	}

}
