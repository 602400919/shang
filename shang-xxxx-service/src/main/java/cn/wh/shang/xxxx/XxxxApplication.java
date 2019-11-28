package cn.wh.shang.xxxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cn.wh.shang.xxxx.rabbit.RabbitTestConfig;


@SpringBootApplication
public class XxxxApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxxxApplication.class, args);
	}
    
	@Bean
	public RabbitTestConfig getRabbitTestConfig() {
		return new RabbitTestConfig();
	}

}
