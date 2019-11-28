package cn.wh.shang.ribbon.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.wh.shang.ribbon.command.HelloServiceCommand;

@RestController
public class ConsumerController {

	/*
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer")
	public String helloConsumer() {
		return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
	}
	*/
	
	/*
	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/consumer")
	public String helloConsumer() {
		return helloService.helloService();
	}
	*/
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer")
	public String helloConsumer() {
		HelloServiceCommand command = new HelloServiceCommand("hello", restTemplate);
		return command.execute();
	}
	
	
	// 以下两个方法未验证
	/*
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer")
	public String helloConsumer() {
		HelloServiceCommand command = new HelloServiceCommand("hello",restTemplate);
		// future的异步调用方式
		Future<String> f = command.queue();
		System.out.println("do other things.");
		return f.get();
	}
	*/
	
	/*
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer")
	public String helloConsumer() {
		// hystrix缓存功能实现，这个功能有点鸡肋
		HystrixRequestContext.initializeContext();
		HelloServiceCommand command = new HelloServiceCommand("hello",restTemplate);
		String execute = command.execute();
		
		return null;
	}*/
}
