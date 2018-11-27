package store.ae.dao.mall.goods;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.mall.goods.GoodsType;

public interface GoodsTypeDao {
	GoodsType queryById(@Param("goodsTypeId") long goodsTypeId);
}
