package com.fhh.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;

/**
 * 消费者2号
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月19日 上午10:40:49
 */
public class SecondMessageCoustom implements ChannelAwareMessageListener {

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		String coustomMessage = new String(message.getBody(), "utf-8");
		System.out.println("消费者2号接收到消息--------------" + coustomMessage);
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
	}

}
