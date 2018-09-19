package com.fhh.rabbitmq.test5;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月22日 上午11:43:36
 */
@Component
public class Send5 {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private TopicExchange topicExchange;

	private String[] key = { "beautiful.tall.white", "ugly.tall.white", "tall.shot.white", "beautiful.tall.white.money",
			"ugly.tall.white" };

	public void send() {
		String msg = key[1];
		System.out.println("发送消息-------" + msg);
		rabbitTemplate.convertAndSend(topicExchange.getName(), msg, msg);
	}
}
