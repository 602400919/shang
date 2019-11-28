package cn.wh.shang.xxxx.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTestConfig {

	 /**  direct类型测试  */
    @Bean
    public DirectExchange xxxxT1DirectExchange() {
    	return new DirectExchange("xxxx.t1.directexchange", false, true);
    }
    
    @Bean
    public Binding xxxxT1Binding() {
    	// 以下三句等效
    	//return new Binding("xxxx.t1.queue", DestinationType.QUEUE, "xxxx.t1.directexchange", "t1.directexchange.to.t1.queue", null); 
    	//return new MyBinding("xxxx.t1.queue", "xxxx.t1.directexchange", "t1.directexchange.to.t1.queue");
    	return BindingBuilder.bind(xxxxT1Queue()).to(xxxxT1DirectExchange()).with("t1.directexchange.to.t1.queue");
    }
    
    @Bean
    public Queue xxxxT1Queue() {
    	return new Queue("xxxx.t1.queue", false, false, true);
    }
    
    @Bean
    public Queue xxxxT1SendTo() {
    	return new Queue("xxxx.t1.queue.sendto", false, false, true);
    }

    /***
     * note: 
     * 	 1、Binding的routing-key是唯一的,唯一标识这个Binding
     *   2、exchange如何绑定到exchange? 
     *   	https://blog.csdn.net/yuanxifan/article/details/88110527
     *   	internal 设置是否是RabbitMQ内部使用，默认false。如果设置为 true ，则表示是内置的交换器，客户端程序无法直接发送消息到这个交换器中，只能通过交换器路由到交换器这种方式。
     *   3、
     * 	 
     */
    
    /** topic类型测试 */
    @Bean
	public Declarables xxxxT3Declare4TopicExchange() {
		return new Declarables(
				new TopicExchange("xxxx.t3.exchange.topic", false, true),
				
				new Queue("xxxx.t3.queue", false, false, true), 
				new Binding("xxxx.t3.queue", DestinationType.QUEUE,"xxxx.t3.exchange.topic", "xxxx.t3.*.#", null),
				
				new Queue("xxxx.t3.queue.x", false, false, true), 
				new Binding("xxxx.t3.queue.x", DestinationType.QUEUE,"xxxx.t3.exchange.topic", "xxxx.*.binding.x.*", null));
	}
    
    /** fanout类型测试 */
    @Bean
    public Declarables xxxxT4Declare4FanoutExchange() {
    	return new Declarables(
    			new FanoutExchange("xxxx.t4.exchange.fanout", false, true),
    			
    			new Queue("xxxx.t4.queue", false, false, true),
    			new Binding("xxxx.t4.queue", DestinationType.QUEUE,"xxxx.t4.exchange.fanout", "xxxx.t4.binding", null),
    			
    			new Queue("xxxx.t4.queue.x", false, false, true),
    			new Binding("xxxx.t4.queue.x", DestinationType.QUEUE,"xxxx.t4.exchange.fanout", "xxxx.t4.bindingx", null));
    }
    
}
