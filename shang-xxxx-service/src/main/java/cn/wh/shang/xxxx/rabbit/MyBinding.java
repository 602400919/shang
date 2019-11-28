package cn.wh.shang.xxxx.rabbit;

import java.util.Map;

import org.springframework.amqp.core.Binding;

public class MyBinding extends Binding {
	
	public MyBinding(String queue, String exchange, String routingKey) {
		this(queue, exchange, routingKey, null);
	}

	public MyBinding(String queue, String exchange, String routingKey, Map<String, Object> arguments) {
		super(queue, DestinationType.QUEUE, exchange, routingKey, arguments);
	}
	
	
}
