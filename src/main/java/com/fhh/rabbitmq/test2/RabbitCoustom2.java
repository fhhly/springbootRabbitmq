package com.fhh.rabbitmq.test2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 定义消费者
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月21日 上午10:33:51
 */
@Component
public class RabbitCoustom2 {

	@RabbitListener(queues = "oneToManyQueue")
	public void receive(String str) {
		System.out.println("消费者二号收到======: " + str);
	}
}
