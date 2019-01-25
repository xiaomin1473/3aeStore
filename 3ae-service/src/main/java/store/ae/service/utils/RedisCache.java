package store.ae.service.utils;

import java.util.concurrent.Callable;

import org.springframework.cache.Cache;

public class RedisCache implements Cache {

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evict(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ValueWrapper get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T get(Object arg0, Class<T> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T get(Object arg0, Callable<T> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getNativeCache() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ValueWrapper putIfAbsent(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
