package store.ae.dao.mall.feast;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.mall.feast.Seckill;

public interface SeckillDao {

	/**
	 * 减库存，
	 * @param seckillId
	 * @param killTime
	 * @return	如果影响行数>1，表示更新的记录行数
	 */
	int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

	/**
	 * 根据ID查询秒杀对象
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);

	/**
	 * 根据偏移查询秒杀对象
	 * @param offet
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 使用存储过程秒杀
	 * @param paramMap
	 */
	void killByProcedure(Map<String, Object> paramMap);

}