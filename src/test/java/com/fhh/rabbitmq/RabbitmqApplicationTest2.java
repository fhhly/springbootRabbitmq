package com.fhh.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fhh.rabbitmq.test2.ProductSend;

/**
 * 测试2
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月21日 上午10:44:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTest2 {
	@Autowired
	private ProductSend productSend;

	@Test
	public void send() {
		productSend.sendMsg();
	}
}
