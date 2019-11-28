package cn.wh.shang.feign.service;

import org.springframework.stereotype.Component;

import cn.wh.shang.common.User;

@Component
public class FallbackService implements FeignService {

	@Override
	public String hello() {
		return "error-hello";
	}

	@Override
	public String hello(String name) {
		return "error-"+name;
	}

	@Override
	public User hello(String name, Integer age) {
		return new User("error-"+name, 10000);
	}

	@Override
	public String hello(User user) {
		return "error-"+user;
	}

}
