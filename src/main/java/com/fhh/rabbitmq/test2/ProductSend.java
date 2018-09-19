package com.fhh.rabbitmq.test2;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月21日 上午10:39:15
 */
@Component
public class ProductSend {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private Queue queue;

	public void sendMsg() {
		for (int i = 0; i < 10; i++) {
			String msg = "消息" + i;
			System.out.println("发送了消息" + msg);
			rabbitTemplate.convertAndSend(queue.getName(), msg);
		}
	}
}
