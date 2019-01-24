package store.ae.service.mall.goods;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
/**
 * @author sidtadpole
 * 
 * 缓存机制说明：所有的查询结果都放进了缓存，也就是把MySQL查询的结果放到了redis中去，
 * 然后第二次发起该条查询时就可以从redis中去读取查询的结果，从而不与MySQL交互，从而达到优化的效果，
 * redis的查询速度之于MySQL的查询速度相当于 内存读写速度 /硬盘读写速度 
 * @Cacheable("a")注解的意义就是把该方法的查询结果放到redis中去，下一次再发起查询就去redis中去取，存在redis中的数据的key就是a；
 * @CacheEvict(value={"a","b"},allEntries=true) 的意思就是执行该方法后要清除redis中key名称为a,b的数据；
 *
 */
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
	
	@Cacheable("getCategoryList")
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
					if(category2.getGradeType().longValue() == category.getCategoryType().longValue()) {
						seriesVo.setCategoryName(category2.getCategoryName());
						seriesVo.setCategoryType(category2.getCategoryType());
						
						List<GradeVo> gradeVoList = new ArrayList<>();
						for(Category category3: list) {
							GradeVo gradeVo = new GradeVo();
							
							if(category3.getGradeType().longValue() == category2.getCategoryType().longValue()) {
								if(category3.getCategoryType().longValue() != 0) {
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
	
	@Cacheable(value="accountCache")
	@Override
	public List<Goods> getGoodsListByCategory(long categoryType, int offset, int limit) {

		return goodsDao.queryAllGoodsByCategory(categoryType, offset, limit);
	}
	
	//@Cacheable("getBrandList")
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
	
	//@Cacheable("getGoodsListByBrandId")
	@Override
	public List<Goods> getGoodsListByBrandId(long brandId, int offset, int limit) {

		return goodsDao.queryAllGoodsByBrandId(brandId, offset, limit);
	}
	
	//@Cacheable("getGoodsList")
	@Override
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//@Cacheable("getGoodsDetailById")
	@Override
	public Goods getGoodsDetailById(long goodsId) {

		return goodsDao.queryGoodsSpuById(goodsId);
	}
	
	//@Cacheable("getAllGoodsSkuById")
	@Override
	public List<GoodsSku> getAllGoodsSkuById(long goodsId) {

		return goodsDao.queryAllGoodsSkuById(goodsId);
	}
	
	//@Cacheable("getGoodsSkuById")
	@Override
	public GoodsSku getGoodsSkuById(long goodsSkuId) {

		return goodsDao.queryGoodsSkuById(goodsSkuId);
	}
	
	//@Cacheable("getGoodsEvaluateById")
	@Override
	public List<GoodsEvaluate> getGoodsEvaluateById(long goodsId) {

		return goodsDao.queryAllGoodsEvaluatesById(goodsId);
	}

}
