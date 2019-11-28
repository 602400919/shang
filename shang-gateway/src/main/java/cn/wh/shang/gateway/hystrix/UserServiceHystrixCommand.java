package cn.wh.shang.gateway.hystrix;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

@Component
public class UserServiceHystrixCommand extends HystrixCommand<String> {
	
	private static final String commandName = "myCommandName";
	
	public UserServiceHystrixCommand() {
		super(HystrixCommandGroupKey.Factory.asKey(commandName));
	}

	@Override
	protected String run() throws Exception {
		return "http://localhost:10000/user-service/user";
	}
	
	@Override
	protected String getFallback() {
		return "UserServiceHystrixCommand-fallback";
	}

}
