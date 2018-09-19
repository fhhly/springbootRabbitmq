package com.fhh.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fhh.rabbitmq.test5.Send5;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTest5 {
	@Autowired
	private Send5 send5;

	@Test
	public void sendMsg() {
		send5.send();
	}
}
