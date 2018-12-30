package store.ae.service.mall.goods;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import store.ae.common.exception.mall.AbsentException;
import store.ae.dao.mall.goods.GoodsDao;
import store.ae.pojo.mall.goods.Brand;
import store.ae.pojo.mall.goods.Category;
import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsSku;
import store.ae.vo.mall.goods.brand.BrandVo;
import store.ae.vo.mall.goods.category.CategoryVo;
import store.ae.vo.mall.goods.category.GradeVo;
import store.ae.vo.mall.goods.category.SeriesVo;

//@Component @Service @Dao @Controller 所有组件
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	private final String ERROR_INFO = "\n【商品服务】";
	
	@SuppressWarnings("rawtypes")
	private void IsNull(List list) { 
		if(null == list || list.size() ==0 ){
			throw new AbsentException(ERROR_INFO + "列表不存在");
		}
	}

	@Override
	public List<CategoryVo> getCategoryList() throws AbsentException{
		List<Category> list = goodsDao.queryAllCategory();
		
		List<CategoryVo> categoryVoList = new ArrayList<>();
		
		IsNull(list);
		
		for(Category category: list) {
			CategoryVo categoryVo = new CategoryVo();
			if(category.getCategoryType() == 1010000) {
				categoryVo.setCategoryName(category.getCategoryName());
				categoryVo.setCategoryType(category.getCategoryType());
				
				List<SeriesVo> seriesVoList = new ArrayList<>();
				for(Category category2: list) {
					SeriesVo seriesVo = new SeriesVo();
					if(category2.getGradeType() == category.getCategoryType() ) {
						seriesVo.setCategoryName(category2.getCategoryName());
						seriesVo.setCategoryType(category2.getCategoryType());
						
						List<GradeVo> gradeVoList = new ArrayList<>();
						for(Category category3: list) {
							GradeVo gradeVo = new GradeVo();
							
							if(category3.getGradeType() == category2.getCategoryType()) {
								if(category3.getCategoryType() != 0) {
									gradeVo.setCategoryName(category3.getCategoryName());
									gradeVo.setCategoryType(category3.getCategoryType());
									
									gradeVoList.add(gradeVo);
								}
							}
						}
						seriesVo.setGradeVoList(gradeVoList);
						seriesVoList.add(seriesVo);
					}
				}
				categoryVo.setSeriesVoList(seriesVoList);
				categoryVoList.add(categoryVo);
			}
		}

		return categoryVoList;
	}

	@Override
	public List<Goods> getGoodsListByCategory(long category, int offset, int limit) {

		return goodsDao.queryAllGoodsByCategory(category, offset, limit);
	}

	@Override
	public List<BrandVo> getBrandList() {
		List<Brand> brands = goodsDao.queryAllBrand();
		List<BrandVo> brandVoList = new ArrayList<>();
		
		for(Brand brand: brands) {
			BrandVo brandVo = new BrandVo();
			
			brandVo.setBrandId(brand.getBrandId());
			brandVo.setBrandName(brand.getBrandName());
			brandVo.setBrandTips(brand.getBrandTips());
			brandVo.setImgUrl(brand.getImgUrl());
			
			brandVoList.add(brandVo);
		}
		
		return brandVoList;
	}

	@Override
	public List<Goods> getGoodsListByBrandId(long brandId, int offset, int limit) {

		return goodsDao.queryAllGoodsByBrandId(brandId, offset, limit);
	}

	@Override
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods getGoodsDetailById(long goodsId) {

		return goodsDao.queryGoodsSpuById(goodsId);
	}

	@Override
	public List<GoodsSku> getAllGoodsSkuById(long goodsId) {

		return goodsDao.queryAllGoodsSkuById(goodsId);
	}

	@Override
	public GoodsSku getGoodsSkuById(long goodsSkuId) {

		return goodsDao.queryGoodsSkuById(goodsSkuId);
	}

	@Override
	public List<GoodsEvaluate> getGoodsEvaluateById(long goodsId) {

		return goodsDao.queryAllGoodsEvaluatesById(goodsId);
	}

}
