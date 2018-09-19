package com.fhh.rabbitmq.test5;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 主题交换器配置
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月22日 上午11:35:41
 */
@Configuration
public class RabbitmqConfig5 {
	/**
	 * 初始化一个主题交换器
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:36:20
	 * @return
	 */
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("myTopicExchange");
	}

	@Bean
	public Queue delQueue1() {
		return new AnonymousQueue();
	}

	@Bean
	public Queue delQueue2() {
		return new AnonymousQueue();
	}

	@Bean
	public Queue delQueue3() {
		return new AnonymousQueue();
	}

	@Bean
	public Queue delQueue4() {
		return new AnonymousQueue();
	}

	/**
	 * 将队列一绑定主题交换器 接收 漂亮，高，白的女孩消息
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:39:46
	 * @return
	 */
	@Bean
	public Binding binding1() {
		return BindingBuilder.bind(delQueue1()).to(topicExchange()).with("beautiful.tall.white");
	}

	/**
	 * 将队列二绑定主题交换器 接收 高，白的女孩消息
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:39:46
	 * @return
	 */
	@Bean
	public Binding binding2() {
		return BindingBuilder.bind(delQueue2()).to(topicExchange()).with("*.tall.white");
	}

	/**
	 * 将队列三绑定主题交换器 接收 白的女孩消息
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:39:46
	 * @return
	 */
	@Bean
	public Binding binding3() {
		return BindingBuilder.bind(delQueue3()).to(topicExchange()).with("*.*.white");
	}

	/**
	 * 将队列四绑定主题交换器 接收 漂亮以及更多形容词的女孩
	 * 
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月22日 上午11:39:46
	 * @return
	 */
	@Bean
	public Binding binding4() {
		return BindingBuilder.bind(delQueue4()).to(topicExchange()).with("beautiful.#");
	}

}
