package store.ae.dao.mall.goods;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.mall.goods.GoodsImage;

public interface GoodsImageDao {
	/**
	 * @param GoodsId
	 * @return
	 */
	GoodsImage queryById(@Param("goodsId") long GoodsId);
}
