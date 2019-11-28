package cn.wh.shang.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@RequestMapping("/default-error")
	public String defaultErrorHandler() {
		return "this is default error handler!";
	}
	
	@RequestMapping("/user-service-provider-error")
	public String userServiceErrorHandler() {
		return "this is user service error handler!";
	}
	
	@RequestMapping("/hello-service-provider-error")
	public String helloServiceErrorHandler() {
		return "this is hello service error Handler";
	}
}
