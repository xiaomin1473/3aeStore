package store.ae.dao.mall.goods;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.mall.goods.GoodsDetail;

public interface GoodsDetailDao {
	GoodsDetail queryById(@Param("goodsId") long goodsId);
}
