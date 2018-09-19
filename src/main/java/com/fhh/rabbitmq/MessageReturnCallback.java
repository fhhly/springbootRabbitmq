package com.fhh.rabbitmq;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;

/**
 * 返回消息
 * @author biubiubiu小浩
 * @date ：2018年7月19日 上午11:03:22
 */
public class MessageReturnCallback implements ReturnCallback {

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange,
			String routingKey) {
		try {
			String returnMessage = new String(message.getBody(), "utf-8");
			System.out.println("回馈消息----------" + returnMessage);
		} catch (UnsupportedEncodingException e) {
			System.out.println("类型转换失败！");
		}
	}

}
