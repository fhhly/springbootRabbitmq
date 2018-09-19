package com.fhh.rabbitmq.test1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	@Bean
	public Queue userQueue() {
		return new Queue("userQueue");
	}

	@Bean
	public Queue dateQueue() {
		return new Queue("dateQueue");
	}
}
