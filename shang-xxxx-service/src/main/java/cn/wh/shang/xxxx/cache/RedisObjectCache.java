package cn.wh.shang.xxxx.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

//@Component // 直接这样使用会报错
public class RedisObjectCache implements ICache<Object> {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void put(String id, Object t) {
		redisTemplate.opsForValue().set(id, t);
	}

	@Override
	public Object get(String id) {
		return redisTemplate.opsForValue().get(id);
	}

}
