package store.ae.dao.mall.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.mall.goods.GoodsEvaluate;

public interface GoodsEvaluateDao {
	List<GoodsEvaluate> queryById(@Param("goodsId") long goodsId);
}
