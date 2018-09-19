package com.fhh.rabbitmq.test1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 测试1
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月20日 下午4:44:56
 */
@Component
public class Test1Send {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue userQueue;

	@Autowired
	private Queue dateQueue;

	public void sendDate() {
		String context = "now date ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(new Date()));
		System.out.println("发送消息------------" + context);
		rabbitTemplate.convertAndSend(dateQueue.getName(), context);
	}

	public void sendUser(User user) {
		System.out.println("发送消息----------" + user);
		rabbitTemplate.convertAndSend(userQueue.getName(), user);
	}
}
