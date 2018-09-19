package com.fhh.rabbitmq.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fhh.rabbitmq.ConnectionFactoryConfig;

/**
 * 推送控制层
 * 
 * @author biubiubiu小浩
 * @date ：2018年7月19日 下午1:18:21
 */
@RestController
public class SendController {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private static Logger logger = LoggerFactory.getLogger(SendController.class);

	@RequestMapping("/send")
	public String sendMessage() {
		String uuid = UUID.randomUUID().toString();
		CorrelationData correlationUuid = new CorrelationData(uuid);
		rabbitTemplate.convertAndSend(ConnectionFactoryConfig.EXCHANGE, ConnectionFactoryConfig.ROUTINGKEY2,
				"springboot-rabbitmq推送", correlationUuid);
		return uuid;
	}
}
