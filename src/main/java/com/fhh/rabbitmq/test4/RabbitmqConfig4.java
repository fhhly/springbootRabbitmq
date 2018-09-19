package com.fhh.rabbitmq.test4;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息订阅配置
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月22日 上午11:04:01
 */
@Configuration
public class RabbitmqConfig4 {
	/**
	 * 初始化一个直连交换器
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:04:36
	 * @return
	 */
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("bindDirectExchange");
	}

	/**
	 * 初始化一个匿名队列
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:06:18
	 * @return
	 */
	@Bean
	public Queue autoDelQueue1() {
		return new AnonymousQueue();
	}

	/**
	 * 初始化一个匿名队列
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:06:18
	 * @return
	 */
	@Bean
	public Queue autoDelQueue2() {
		return new AnonymousQueue();
	}

	/**
	 * 将队列一绑定到直连交换器并订阅 有关cat的消息
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:08:44
	 * @param autoDelQueue1
	 * @param directExchange
	 * @return
	 */
	@Bean
	public Binding binding1(Queue autoDelQueue1, DirectExchange directExchange) {
		return BindingBuilder.bind(autoDelQueue1).to(directExchange).with("cat");
	}
	/**
	 * 将队列一绑定到直连交换器并订阅 有关dog的消息
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:08:44
	 * @param autoDelQueue1
	 * @param directExchange
	 * @return
	 */
	@Bean
	public Binding binding2(Queue autoDelQueue1, DirectExchange directExchange) {
		return BindingBuilder.bind(autoDelQueue1).to(directExchange).with("dog");
	}
	/**
	 * 将队列一绑定到直连交换器并订阅 有关dog的消息
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:08:44
	 * @param autoDelQueue1
	 * @param directExchange
	 * @return
	 */
	@Bean
	public Binding binding3(Queue autoDelQueue2, DirectExchange directExchange) {
		return BindingBuilder.bind(autoDelQueue2).to(directExchange).with("dog");
	}
	/**
	 * 将队列一绑定到直连交换器并订阅 有关mouse的消息
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:08:44
	 * @param autoDelQueue1
	 * @param directExchange
	 * @return
	 */
	@Bean
	public Binding binding4(Queue autoDelQueue2, DirectExchange directExchange) {
		return BindingBuilder.bind(autoDelQueue2).to(directExchange).with("mouse");
	}
}
