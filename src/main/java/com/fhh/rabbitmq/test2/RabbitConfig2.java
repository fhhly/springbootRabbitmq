package com.fhh.rabbitmq.test2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定义一个队列，两个消费者
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月21日 上午10:31:21
 */
@Configuration
public class RabbitConfig2 {
	@Bean
	public Queue queue() {
		return new Queue("oneToManyQueue");
	}

	@Bean
	public RabbitCoustom rabbitCoustom1() {
		return new RabbitCoustom();
	}

	@Bean
	public RabbitCoustom2 rabbitCoustom2() {
		return new RabbitCoustom2();
	}

	@Bean
	public ProductSend productSend() {
		return new ProductSend();
	}
}
