package cn.wh.shang.ribbon.command;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * 自定义hystrix策略
 * @author Administrator
 *
 */
public class HelloServiceCommand extends HystrixCommand<String> {
	
	private RestTemplate restTemplate;

	public HelloServiceCommand(String commandGroupKey, RestTemplate restTemplate) {
		super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
		this.restTemplate = restTemplate;
	}

	@Override
	protected String run() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
	}
	
	@Override
	protected String getFallback() {
		return "error";
	}
	
	/*
	@Override
	protected String getCacheKey() {
		return "hello";
	}
	*/

}
