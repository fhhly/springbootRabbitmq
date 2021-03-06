package com.fhh.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fhh.rabbitmq.test3.ProductSend3;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTest3 {
	@Autowired
	private ProductSend3 productSend3;

	@Test
	public void sendMsg() {
		productSend3.send();
	}
}
