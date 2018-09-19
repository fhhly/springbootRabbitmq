package com.fhh.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fhh.rabbitmq.test4.Send;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTest4 {
	@Autowired
	private Send send;

	@Test
	public void sendMsg() {
		send.Send();
	}
}
