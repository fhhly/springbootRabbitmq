package com.fhh.rabbitmq.test1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Test1Recevie {
	@RabbitListener(queues = "dateQueue")
	public void dateRecevie(String date) {
		System.out.println("recevie---------" + date);
	}

	@RabbitListener(queues = "userQueue")
	public void dateRecevie(User user) {
		System.out.println("recevie---------" + user);
		System.out.println("recevie---------" + user.getUserName());
		System.out.println("recevie---------" + user.getAge());
	}
}
