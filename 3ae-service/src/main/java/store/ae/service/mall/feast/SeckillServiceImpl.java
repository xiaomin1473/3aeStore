package store.ae.service.mall.feast;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import store.ae.common.enums.mall.feast.SeckillStatEnum;
import store.ae.common.exception.CloseException;
import store.ae.common.exception.RepeatException;
import store.ae.common.exception.mall.feast.SeckillException;
import store.ae.dao.mall.cache.RedisDao;
import store.ae.dao.mall.feast.SeckillDao;
import store.ae.dao.mall.feast.SeckillSuccessDao;
import store.ae.dto.mall.feast.Exposer;
import store.ae.dto.mall.feast.SeckilllExecution;
import store.ae.pojo.mall.feast.Seckill;
import store.ae.pojo.mall.feast.SeckillSuccess;

// @Component @Service @Dao @Controller 所有组件
@Service
public class SeckillServiceImpl implements SeckillService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillDao seckillDao;
	
	// 注入service依赖
	@Autowired // @Resource, @Inject
	private SeckillSuccessDao seckillSuccessDao;

	@Autowired
	private RedisDao redisDao;
	
	private final String ERROR_INFO = "\n【秒杀服务】";
	
	// md5盐值字符串，用来混淆md5
	private final String slat = "Aa^p1%@HW+_ijfo&-i14#YgaFO*Htg1a_G$PIT5*%er#HLwr*aMF#48_5GA(mf15a^sfaw6";
	
	private String getMD5(long seckillId) {
		String base = seckillId +"/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		
		return md5;
	}
	
	@Override
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	@Override
	public Seckill getById(long seckillId) {
		
		return seckillDao.queryById(seckillId);
	}

	/* (non-Javadoc)
	 * @see store.ae.service.mall.feast.SeckillService#exportSeckillUrl(long)
	 */
	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		// redis优化，redis缓存:超时基础上维护一致性
		/*
		 * get form cache 
		 * if null
		 *   get db
		 * else
		 * 	 put cache
		 * logic
		 */
		// 访问redis
		Seckill seckill = redisDao.getSeckill(seckillId);
		
		if(seckill == null) {
			seckill = seckillDao.queryById(seckillId);
			
			if(seckill == null) {
				return new Exposer(false, seckillId);
			}
		} else {
			redisDao.putSeckill(seckill);
		}
		System.out.println(seckill.toString());
		
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		
		// 系统时间
		Date nowTime = new Date();
		
		if(nowTime.getTime() < startTime.getTime()
				||	nowTime.getTime() > endTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}
		
		// 转化特点字符串，不可逆
		String md5 = getMD5(seckillId);
		
		return new Exposer(true, md5, seckillId);
	}


	
	/* (non-Javadoc)
	 * 
	 * 使用注解控制事务方法的优点：
	 * 1.开发团队达成一致约定，明确标注事务方法的编程风格
	 * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作：缓存/redis/mechache/http请求/RPC请求或者剥离到事务方法外部
	 * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
	 * 
	 * @see store.ae.service.mall.feast.SeckillService#executeSeckill(long, long, java.lang.String)
	 */
	@Override
	@Transactional
	public SeckilllExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatException, CloseException {
		if(md5 == null || !md5.equals(getMD5(seckillId))) {
			throw new SeckillException(ERROR_INFO + "seckill date rewrite");
		}
		// 执行秒杀逻辑：减库存 + 记录秒杀行为
		Date nowTime = new Date();
		
		try {
			// 记录购买行为
			int insertCount = seckillSuccessDao.insertSeckillSuccess(seckillId, userPhone);
			// 唯一验证
			if(insertCount <=0) {
				// 重复秒杀
				throw new RepeatException(ERROR_INFO + "seckill is repeat");
			} else {
				// 减库存，行级锁竞争
				int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
				
				if(updateCount <=0) {
					// 没有更新记录,秒杀结束 rollback
					throw new CloseException(ERROR_INFO + "seckill is close");
				} else {
					// 秒杀成功,commit
					SeckillSuccess seckillSuccess = seckillSuccessDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckilllExecution(seckillId, SeckillStatEnum.SUCCESS, seckillSuccess);
				}
			}
			
		} catch(CloseException e1) {
			throw e1;
		} catch (RepeatException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// 编译期异常转化为运行期异常
			throw new SeckillException(ERROR_INFO + "seckill inner error" + e.getMessage());
		}
	}

	@Override
	public SeckilllExecution executeSeckillProcedure(long seckillId, long userPhone, String md5) {

		if(md5 == null || !md5.equals(getMD5(seckillId))) {
			return new SeckilllExecution(seckillId, SeckillStatEnum.DATA_REWRITE);
		}
		
		Date killTime = new Date();
		
		Map<String, Object> map = new HashMap<String, Object> ();
		map.put("seckillId", seckillId);
		map.put("phone", userPhone);
		map.put("killTime", killTime);
		map.put("result", null);
		
		// 执行存储过程，result被赋值
		try {
			seckillDao.killByProcedure(map);
			// 获取result
			int result = MapUtils.getInteger(map, "result", -2);
			if(result == 1) {
				SeckillSuccess sk = seckillSuccessDao
						.queryByIdWithSeckill(seckillId, userPhone);
				return new SeckilllExecution(seckillId, SeckillStatEnum.SUCCESS, sk);
			}else {
				return new SeckilllExecution(seckillId, SeckillStatEnum.stateof(result));
			}
		} catch (Exception e) {
			logger.error(ERROR_INFO + SeckillStatEnum.INNER_ERROR + e.getMessage());
			return new SeckilllExecution(seckillId, SeckillStatEnum.INNER_ERROR);
		}
	}
}
