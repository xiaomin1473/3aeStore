package store.ae.dao.mall.cache;

import io.protostuff.LinkBuffer;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import store.ae.pojo.mall.feast.Seckill;

public class RedisDao {
	private JedisPool jedisPool;
	
	private RuntimeSchema<Seckill> seckillSchema = RuntimeSchema.createFrom(Seckill.class);
	
	public RedisDao(String ip, int port) {
		jedisPool = new JedisPool(ip, port);
	}
	
	public Seckill getSeckill(long seckillId) {
		// redis操作逻辑
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill" + seckillId;
				
				/* 
				* 没有内部实现序列化
				* get -> byte[] -> 反序列化 -> Object(seckill)
				* 自定义序列化 
				* protostuff: pojo
				*/
				byte[] bytes = jedis.get(key.getBytes());
				if(bytes != null) {
					// 空对象
					Seckill seckill = seckillSchema.newMessage();
					ProtostuffIOUtil.mergeFrom(bytes, seckill, seckillSchema);
					//被反序列化
					return seckill;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				jedis.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public String putSeckill(Seckill seckill) {
		// put Object(Seckill) => 序列化 => Byte[]
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill" + seckill.getSeckillId();
				byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, seckillSchema,
							LinkedBuffer.allocate(LinkBuffer.DEFAULT_BUFFER_SIZE));
				
				// 超时缓存
				int timeout = 60 * 60;
				String result = jedis.setex(key.getBytes(), timeout, bytes);
				
				return result;
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
}