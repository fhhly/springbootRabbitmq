package com.fhh.rabbitmq.test3;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月21日 下午1:21:34
 */
@Configuration
public class RabbitConfig3 {
	/**
	 * 定义广播交换器
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月21日 下午1:22:27
	 * @return
	 */
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("myFanoutExchange");
	}

	/**
	 * 匿名队列，不耐用，独占，自动删除的队列
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月21日 下午1:23:23
	 * @return
	 */
	@Bean
	public Queue anonymousQueue1() {
		return new AnonymousQueue();
	}

	@Bean
	public Queue anonymousQueue2() {
		return new AnonymousQueue();
	}

	@Bean
	public ProductSend3 productSend3() {
		return new ProductSend3();
	}

	@Bean
	public Binding binding1() {
		return BindingBuilder.bind(anonymousQueue1()).to(fanoutExchange());
	}

	@Bean
	public Binding binding2() {
		return BindingBuilder.bind(anonymousQueue2()).to(fanoutExchange());
	}
}
