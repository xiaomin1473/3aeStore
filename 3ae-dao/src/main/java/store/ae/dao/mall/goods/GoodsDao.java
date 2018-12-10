package store.ae.dao.mall.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.mall.goods.Brand;
import store.ae.pojo.mall.goods.Category;
import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsDetail;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsImage;

public interface GoodsDao {
	/**
	 * @param GoodsId
	 * @return
	 */
	Goods queryById(@Param("goodsId") long goodsId);


	List<Category> queryCategory();

	List<Brand> queryBrand();

	/**
	 * @param category
	 * 			根据分类
	 * @param offset
	 * 			偏移量
	 * @param limit
	 * 			范围
	 * @return
	 */
	List<Goods> queryAllByCategory(@Param("category") long category, @Param("offset") int offset, @Param("limit") int limit);

	/**
	 * @param brand
	 * 			根据品牌
	 * @param offset
	 * 			偏移量
	 * @param limit
	 * 			范围
	 * @return
	 */
	List<Goods> queryAllByBrand(@Param("brand") long brand, @Param("offset") int offset, @Param("limit") int limit);
	
	
	GoodsDetail queryDetailById(@Param("goodsId") long goodsId);
	
	GoodsImage queryImageById(@Param("goodsId") long goodsId);
	
	/**
	 * @param goodsId
	 * @return
	 */
	List<GoodsEvaluate> queryEvaluatesById(@Param("goodsId") long goodsId);
	
	
}
