package cn.wh.shang.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.shang.common.User;
import cn.wh.shang.feign.service.FeignService;

@RestController
public class ConsumerController {

	@Autowired
	private FeignService feignService;
	
	@RequestMapping("/consumer1")
	public String helloConsumer1() {
		return feignService.hello();
	}
	
	@RequestMapping("/consumer2")
	public String helloConsumer2() {
		String r1 = feignService.hello("wanghuan");
		User r2 = feignService.hello("liubei", 28);
		String r3 = feignService.hello(new User("messi", 22));
		
		return r1 + "----" + r2 + "----" + r3;
	}

	
}