package store.ae.service.mall.feast;

import java.util.List;

import store.ae.common.exception.CloseException;
import store.ae.common.exception.RepeatException;
import store.ae.common.exception.mall.feast.SeckillException;
import store.ae.dto.mall.feast.Exposer;
import store.ae.dto.mall.feast.SeckilllExecution;
import store.ae.pojo.mall.feast.Seckill;

/**
 * @author sidtadpole
 * 
 * 业务接口：站在“使用者”的角度设计接口
 * 1.方法定义粒度
 * 2.参数
 * 3.返回类型(return 类型/异常)
 * 
 */
public interface SeckillService {
	
	/**
	 * 查询所有秒杀记录
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * 根据ID查询秒杀记录
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * 秒杀开启时输出秒杀接口的地址，否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * 执行秒杀操作
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return
	 */
	SeckilllExecution executeSeckill(long seckillId, long userPhone, String md5)
		throws SeckillException, RepeatException, CloseException;
	
	/**
	 * 执行秒杀操作 by 存储过程
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return
	 */
	SeckilllExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
