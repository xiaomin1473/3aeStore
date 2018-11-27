package store.ae.service.mall.goods;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.ae.dao.mall.goods.GoodsDao;
import store.ae.dao.mall.goods.GoodsDetailDao;
import store.ae.dao.mall.goods.GoodsEvaluateDao;
import store.ae.dao.mall.goods.GoodsImageDao;
import store.ae.dao.mall.goods.GoodsTypeDao;
import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsDetail;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsImage;
import store.ae.pojo.mall.goods.GoodsType;

@Service
public class GoodsServiceImpl implements GoodsService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
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

	@Override
	public List<Goods> getGoodsList() {
		
		int offset = 0;
		int limit = 10;
		
		List<Goods>goods = goodsDao.queryAll(offset, limit);
		
		return goods;
	}

	@Override
	public Goods getGoodsById(long GoodsId) {
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
		
		return null;
	}
	

}