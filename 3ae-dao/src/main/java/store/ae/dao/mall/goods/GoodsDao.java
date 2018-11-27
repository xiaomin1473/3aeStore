package store.ae.dao.mall.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.mall.goods.Goods;

public interface GoodsDao {
	/**
	 * @param GoodsId
	 * @return
	 */
	Goods queryById(@Param("goodsId") long goodsId);
	
	
	/**
	 * @param offset
	 * 			偏移
	 * @param limit
	 * 			范围
	 * @return
	 */
	List<Goods> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
