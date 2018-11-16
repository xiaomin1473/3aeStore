package store.ae.service.mall.feast.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import store.ae.dao.mall.feast.SeckillDao;
import store.ae.dao.mall.feast.SeckillSuccessDao;
import store.ae.dto.service.mall.feast.Exposer;
import store.ae.dto.service.mall.feast.SeckilllExecution;
import store.ae.enums.mall.feast.SeckillStatEnum;
import store.ae.exception.mall.feast.SeckillCloseException;
import store.ae.exception.mall.feast.SeckillException;
import store.ae.exception.mall.feast.SeckillRepeatException;
import store.ae.pojo.mall.feast.Seckill;
import store.ae.pojo.mall.feast.SeckillSuccess;
import store.ae.service.mall.feast.SeckillService;

// @Component @Service @Dao @Controller 所有组件
@Service
public class SeckillServiceImpl implements SeckillService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 注入service依赖
	@Autowired // @Resource, @Inject
	private SeckillSuccessDao seckillSuccessDao;
	
	@Autowired
	private SeckillDao seckillDao;
	
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
		// redis优化，redis缓存
		/*
		 * get form cache 
		 * if null
		 *   get db
		 * else
		 * 	 put cache
		 * logic
		 */
		Seckill seckill = seckillDao.queryById(seckillId);
		
		if(seckill == null) {
			return new Exposer(false, seckillId);
		}
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
			throws SeckillException, SeckillRepeatException, SeckillCloseException {
		if(md5 == null || !md5.equals(getMD5(seckillId))) {
			throw new SeckillException("seckill date rewrite");
		}
		// 执行秒杀逻辑：减库存 + 记录秒杀行为
		Date nowTime = new Date();
		
		try {
			// 减库存
			int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
			
			if(updateCount <=0) {
				// 没有更新记录,秒杀结束
				throw new SeckillCloseException("seckill is close");
			} else {
				// 记录购买行为
				int insertCount = seckillSuccessDao.insertSeckillSuccess(seckillId, userPhone);
				// 唯一验证
				if(insertCount <=0) {
					throw new SeckillRepeatException("seckill is repeat");
				} else {
					// 秒杀成功
					SeckillSuccess seckillSuccess = seckillSuccessDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckilllExecution(seckillId, SeckillStatEnum.SUCCESS, seckillSuccess);
				}
			}
		} catch(SeckillCloseException e1) {
			throw e1;
		} catch (SeckillRepeatException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// 编译期异常转化为运行期异常
			throw new SeckillException("seckill inner error:" + e.getMessage());
		}
		
	}
}
