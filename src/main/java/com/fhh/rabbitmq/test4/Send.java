package com.fhh.rabbitmq.test4;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月22日 上午11:12:00
 */
@Component
public class Send {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private DirectExchange directExchange;

	private String[] key = { "cat", "dog", "mouse","sheep" };

	public void Send() {
		String msg = key[3];
		System.out.println("发送消息-----" + key[3]);
		rabbitTemplate.convertAndSend(directExchange.getName(), key[3], msg);
	}
}
