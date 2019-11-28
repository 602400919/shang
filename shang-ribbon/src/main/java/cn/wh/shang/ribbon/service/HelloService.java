package cn.wh.shang.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallbackHello")
	public String helloService() {
		return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
	}
	
	public String fallbackHello() {
		return "error-fallback";
	}
}
