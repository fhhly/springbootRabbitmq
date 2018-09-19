package com.fhh.rabbitmq.test3;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月21日 下午1:28:43
 */
@Component
public class Coustom {
	@RabbitListener(queues = "#{anonymousQueue1.name}")
	public void costom1(String msg) {
		System.out.println("一号消费者受到消息-----------" + msg);
	}

	@RabbitListener(queues = "#{anonymousQueue2.name}")
	public void costom2(String msg) {
		System.out.println("二号消费者受到消息-----------" + msg);
	}

}
