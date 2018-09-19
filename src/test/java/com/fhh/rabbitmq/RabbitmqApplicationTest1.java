package com.fhh.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fhh.rabbitmq.test1.Test1Send;
import com.fhh.rabbitmq.test1.User;

/**
 * 测试一
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月21日 上午9:48:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTest1 {
	@Autowired
	private Test1Send test1Send;

	@Test
	public void testSendDate() {
		test1Send.sendDate();
	}

	@Test
	public void testSendUser() {
		User user = new User();
		user.setAge("18");
		user.setUserName("ly");
		test1Send.sendUser(user);
	}
}
