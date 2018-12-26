package store.ae.service.mall.goods;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.ae.dao.mall.goods.GoodsDao;
import store.ae.pojo.mall.goods.Brand;
import store.ae.pojo.mall.goods.Category;
import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsSku;
import store.ae.vo.mall.goods.category.CategoryVo;
import store.ae.vo.mall.goods.category.GradeVo;
import store.ae.vo.mall.goods.category.SeriesVo;

//@Component @Service @Dao @Controller 所有组件
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public List<CategoryVo> getCategoryList() {
		/*
		 *  01000000 一级
		 *  01010000 二级
		 *  01010100 三级
		 *  01010101 四级
		 *  
		 *  data: [
		 *  {
		 *  	"name": "京东自营",
		 *  	"type": 1010000,
		 *  	"child": [
		 *  		{
		 *  			"name": "电子",
		 *  			"type": "1010100",
		 *  			"child": [
		 *  				{
		 *  					"name": "手机",
		 *  					"type": "1010101"
		 *  				},
		 *  				{
		 *  					"name": "相机",
		 *  					"type": "1010102"
		 *  				},
		 *  			]
		 *  		},
		 *  	]
		 *  }]
		 *  
		 */
		
		List<Category> list = goodsDao.queryAllCategory();
		
		List<CategoryVo> categoryVoList = new ArrayList<>();
		if(null == list || list.size() ==0 ){ return categoryVoList = null; }
		
		
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
