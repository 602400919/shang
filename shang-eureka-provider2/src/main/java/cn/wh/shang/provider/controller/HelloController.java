package cn.wh.shang.provider.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.shang.common.User;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello2";
	}

	// 新增的方法
	@RequestMapping(value = "/hellol", method = RequestMethod.GET)
	public String hello(@RequestParam String name) {
		return "Hello2 " + name;
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public User hello(@RequestHeader String name, @RequestHeader Integer age) {
		return new User(name, age);
	}

	@RequestMapping(value = "/hello3", method = RequestMethod.POST)
	public String hello(@RequestBody User user) {
		return "Hello2 " + user.getName() + ", " + user.getAge();
	}
}
