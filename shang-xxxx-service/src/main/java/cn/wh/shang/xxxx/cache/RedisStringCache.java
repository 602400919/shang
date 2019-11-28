package cn.wh.shang.xxxx.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisStringCache implements ICache<String> {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public void put(String id, String t) {
		redisTemplate.opsForValue().set(id, t);
	}

	@Override
	public String get(String id) {
		return redisTemplate.opsForValue().get(id);
	}

}