package cn.wh.shang.xxxx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.shang.common.User;
import cn.wh.shang.xxxx.cache.RedisStringCache;

@RestController
@RequestMapping("/redistest")
public class RedisTestController {
	private static final Logger logger = LoggerFactory.getLogger(RedisTestController.class);
	
	private static final long DEFAULT_EXPIRE = 60000;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private RedisStringCache redisStringCache;

	@RequestMapping("/add")
	public String addTest(@RequestParam("key") String key, @RequestParam("value") String value) {
		redisTemplate.opsForValue().set(key, value, DEFAULT_EXPIRE);
		logger.info("已经设置redis.key={}, value={}", key, value);
		
		String value2 = redisTemplate.opsForValue().get(key);
		logger.info("取出redis数据.key={}, value={}", key, value2);
		
		redisStringCache.put("u123", new User("wanghuan",45).toString());
		String ustr = redisStringCache.get("u123");
		logger.info("获取到redis对象数据.id={},date={},value={}","u123", System.currentTimeMillis(), ustr);
		
		return "success";
	}
}
