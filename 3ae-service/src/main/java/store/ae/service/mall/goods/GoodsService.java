package store.ae.service.mall.goods;

import java.util.List;

import store.ae.common.exception.mall.AbsentException;
import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsSku;
import store.ae.vo.mall.goods.brand.BrandVo;
import store.ae.vo.mall.goods.category.CategoryVo;

/**
 * @author sidtadpole
 * 
 * 业务接口：站在“使用者”的角度设计接口
 * 1.方法定义粒度
 * 2.参数
 * 3.返回类型(return 类型/异常)
 * 
 */
public interface GoodsService {

	/**
	 * 获取分类列表
	 * @return
	 */
	List<CategoryVo> getCategoryList() throws AbsentException;
	
	/**
	 * 根据分类获取商品列表
	 * @param Category
	 * @return
	 */
	List<Goods> getGoodsListByCategory(long categoryType, int offset, int limit);

	/**
	 * 获取品牌列表
	 * @return
	 */
	List<BrandVo> getBrandList();
	
	/**
	 * 根据品牌ID获取商品列表
	 * @param BrandId
	 * @return
	 */
	List<Goods> getGoodsListByBrandId(long brandId, int offset, int limit);
	
	/**
	 * 获取商品列表
	 * @return
	 */
	List<Goods> getGoodsList();

	/**
	 * 根据商品ID获取商品详情,SPU总详情
	 * @param GoodsId
	 * @return
	 */
	Goods getGoodsDetailById(long goodsId);
	
	/**
	 * 根据商品ID获取SKU信息
	 * @param GoodsId
	 * @return
	 */
	List<GoodsSku> getAllGoodsSkuById(long goodsId);
	
	/**
	 * 根据商品ID获取SKU信息
	 * @param GoodsId
	 * @return
	 */
	GoodsSku getGoodsSkuById(long goodsSkuId);
	
	/**
	 * 
	 * 根据商品ID获取商品评价列表
	 * @param GoodsId
	 * @return
	 */
	List<GoodsEvaluate> getGoodsEvaluateById(long goodsId);

	

	
}
