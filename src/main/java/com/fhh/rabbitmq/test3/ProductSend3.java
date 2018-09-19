package com.fhh.rabbitmq.test3;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送消息
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月21日 下午1:25:35
 */
@Component
public class ProductSend3 {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private FanoutExchange fanoutExchange;

	public void send() {
		for (int i = 0; i < 10; i++) {
			String msg = "广播消息-----" + i;
			System.out.println(msg);
			rabbitTemplate.convertAndSend(fanoutExchange.getName(),"", msg);
		}
	}
}
