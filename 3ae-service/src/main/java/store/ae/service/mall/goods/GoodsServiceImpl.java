package store.ae.service.mall.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.ae.dao.mall.goods.GoodsDao;
import store.ae.pojo.mall.goods.Brand;
import store.ae.pojo.mall.goods.Category;
import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsSku;

//@Component @Service @Dao @Controller 所有组件
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public List<Category> getCategoryList() {		
		return goodsDao.queryAllCategory();
	}

	@Override
	public List<Goods> getGoodsListByCategory(long category, int offset, int limit) {
		// TODO Auto-generated method stub
		return goodsDao.queryAllGoodsByCategory(category, offset, limit);
	}

	@Override
	public List<Brand> getBrandList() {
		// TODO Auto-generated method stub
		return goodsDao.queryAllBrand();
	}

	@Override
	public List<Goods> getGoodsListByBrandId(long brandId, int offset, int limit) {
		// TODO Auto-generated method stub
		return goodsDao.queryAllGoodsByBrandId(brandId, offset, limit);
	}

	@Override
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods getGoodsDetailById(long goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.queryGoodsSpuById(goodsId);
	}

	@Override
	public List<GoodsSku> getAllGoodsSkuById(long goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.queryAllGoodsSkuById(goodsId);
	}

	@Override
	public GoodsSku getGoodsSkuById(long goodsSkuId) {
		// TODO Auto-generated method stub
		return goodsDao.queryGoodsSkuById(goodsSkuId);
	}

	@Override
	public List<GoodsEvaluate> getGoodsEvaluateById(long goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.queryAllGoodsEvaluatesById(goodsId);
	}

}
