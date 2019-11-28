package cn.wh.shang.xxxx.rabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

	@RabbitListener(queues="xxxx.t1.queue")
	@SendTo("xxxx.t1.queue.sendto")
	public String t1test(String message) {
		logger.info("receive message [{}] from xxxx.direct.myqueue", message);
		return message;
	}
	
	@RabbitListener(queues="xxxx.t3.queue")
	public void t3test(String message) {
		logger.info("receive message [{}] from xxxx.t3.queue", message);
	}
	
}