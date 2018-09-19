package com.fhh.rabbitmq.test4;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月22日 上午11:18:01
 */
@Component
public class CoustomRecive {
	// 监听匿名队列一
	@RabbitListener(queues = "#{autoDelQueue1.name}")
	public void coustom1(String msg) {
		System.out.println("消费者1号接收到-----------" + msg);
	}

	// 监听匿名队列二
	@RabbitListener(queues = "#{autoDelQueue2.name}")
	public void coustom2(String msg) {
		System.out.println("消费者2号接收到-----------" + msg);
	}

}
