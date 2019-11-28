package cn.wh.shang.xxxx.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReceiveAndReplyCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitTestController {
	private static final Logger logger = LoggerFactory.getLogger(RabbitTestController.class);
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	// 不订阅队列，从队列中获取消息
	@RequestMapping("/receive")
	public String receive(@RequestParam("queueName") String queueName) {
		String res = null;
		try {
			Message message = amqpTemplate.receive(queueName, 1000);
			res = message.toString();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return res;
	}

	@RequestMapping("/direct")
	public String sendDirect(@RequestParam("qname")String qname) {
		String message = "current-time:"+new Date();
		logger.info("send messge [{}] to direct-queue {}", message, qname);
		amqpTemplate.convertAndSend(qname, message);
		return message;
	}
	
	@RequestMapping("/t1test")
	public String testT1(@RequestParam("message")String message) {
		logger.info("send messge [{}] }", message);
		amqpTemplate.convertAndSend("xxxx.t1.directexchange" , "t1.directexchange.to.t1.queue", message);
		return message;
	}
	
	@RequestMapping("/t3test")
	public String testT3(@RequestParam("message") String message) {
		logger.info("send messge [{}] }", message);
		String responseMessage = new Date()+"<br/>"+message;
		amqpTemplate.convertAndSend("xxxx.t3.exchange.topic" , "xxxx.t3.binding.x.test", responseMessage);
		return responseMessage;
	}
	
	@RequestMapping("/t4test")
	public String testT4(@RequestParam("message") String message) {
		logger.info("send messge [{}] }", message);
		String responseMessage = new Date()+"<br/>"+message;
		amqpTemplate.convertAndSend("xxxx.t4.exchange.fanout" , "", responseMessage);
		return responseMessage;
	}
	
	@RequestMapping("/t5test")
	public String testT5() {
		ReceiveAndReplyCallback<String, String> callback = payload -> {
			logger.info("receive:"+payload+",response hehe!");
			return "receive:"+payload+",response hehe!";
		};
		boolean r = amqpTemplate.receiveAndReply("xxxx.t3.queue.x", callback, "xxxx.t4.exchange.fanout", "fanout-key-will-be-ignore");
		return r ? "success" : "failure";
	}
	
}
