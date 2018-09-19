package com.fhh.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;

/**
 * 消费者
 * @author biubiubiu小浩
 * @date ：2018年7月19日 上午9:42:03
 */
public class MessageCoustom implements ChannelAwareMessageListener {

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		String coustomMessage = new String(message.getBody(), "utf-8");
		System.out.println("消费者1号接收到消息--------------" + coustomMessage);
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}
}
