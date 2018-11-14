package store.ae.dao.mall.feast;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.mall.feast.SeckillSuccess;

public interface SeckillSuccessDao {

	/**
	 * 插入购买明细，可过滤重复
	 * @param seckillId
	 * @param userphone
	 * @return 	插入行数
	 */
	int insertSeckillSuccess(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

	/**
	 * 根据id查询FeastSeckillSuccess并携带秒杀产品对象实体
	 * @param seckillId
	 * @return
	 */
	SeckillSuccess queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}