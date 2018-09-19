package com.fhh.rabbitmq.test5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月22日 上午11:50:00
 */
@Component
public class Recevice {

	@RabbitListener(queues = "#{delQueue1.name}")
	public void coustom1(String msg) {
		System.out.println("消费者1接收到---------" + msg);
	}

	@RabbitListener(queues = "#{delQueue2.name}")
	public void coustom2(String msg) {
		System.out.println("消费者2接收到---------" + msg);
	}

	@RabbitListener(queues = "#{delQueue3.name}")
	public void coustom3(String msg) {
		System.out.println("消费者3接收到---------" + msg);
	}

	@RabbitListener(queues = "#{delQueue4.name}")
	public void coustom4(String msg) {
		System.out.println("消费者4接收到---------" + msg);
	}
}
