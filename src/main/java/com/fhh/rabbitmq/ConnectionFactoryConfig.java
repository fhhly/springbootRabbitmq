package com.fhh.rabbitmq;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq配置
 * @author biubiubiu小浩
 * @date ：2018年7月18日 下午4:13:34
 */
@Configuration
public class ConnectionFactoryConfig {
	@Value("${spring.rabbitmq.username}")
	public String username;
	@Value("${spring.rabbitmq.password}")
	public String password;
	@Value("${spring.rabbitmq.virtual-host}")
	public String vHost;
	@Value("${spring.rabbitmq.port}")
	public int port;
	@Value("${spring.rabbitmq.host}")
	public String host;

	/**
	 * 交换器
	 */
	public static final String EXCHANGE = "myExchange";
	// 队列1
	public static final String ROUTINGKEY1 = "queue_key1";
	// 队列2
	public static final String ROUTINGKEY2 = "queue_key2";

	// 创建链接工厂
	@Bean
	public CachingConnectionFactory getConnectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(this.host,
				this.port);
		cachingConnectionFactory.setUsername(this.username);
		cachingConnectionFactory.setPassword(this.password);
		cachingConnectionFactory.setVirtualHost(this.vHost);
		cachingConnectionFactory.setPublisherConfirms(true);
		return cachingConnectionFactory;
	}

	/**
	 * directExchange
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月18日 下午4:48:27 
	 * @return
	 */
	@Bean
	public DirectExchange directExchange() {
		DirectExchange directExchange = new DirectExchange(ConnectionFactoryConfig.EXCHANGE, true,
				false);
		return directExchange;
	}

	/**
	 * 创建队列
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月18日 下午5:33:48 
	 * @return
	 */
	@Bean
	public Queue firstQueue() {
		Queue queue = new Queue("firstQueue", true, false, false);
		return queue;
	}

	/**
	 * 将firstQueue与交换器绑定
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月19日 上午8:44:07 
	 * @return
	 */
	@Bean
	public Binding firstBinding() {
		return BindingBuilder.bind(firstQueue()).to(directExchange()).with(ROUTINGKEY1);
	}

	/**
	 * durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
	 * auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
	 * exclusive  表示该消息队列是否只在当前connection生效,默认是false
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月19日 上午9:29:06 
	 * @return
	 */
	@Bean
	public Queue secondQueue() {
		return new Queue("secondQueue", true, false, false);
	}

	/**
	 * 将队列2与交换器绑定
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月19日 上午9:33:59 
	 * @return
	 */
	@Bean
	public Binding secondBinding() {
		return BindingBuilder.bind(secondQueue()).to(directExchange()).with(ROUTINGKEY2);
	}

	/**
	 * 监听模式，当有消息到达队列时，会通知对应的监听对象
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月19日 上午10:27:23 
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer firstSimpleMessageListenerContainer() {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(
				getConnectionFactory());
		// 设置监听队列
		simpleMessageListenerContainer.addQueues(firstQueue());
		simpleMessageListenerContainer.setExposeListenerChannel(true);
		// 并发消费者的最大数目
		simpleMessageListenerContainer.setMaxConcurrentConsumers(1);
		simpleMessageListenerContainer.setConcurrentConsumers(1);
		// 设置确认模式 手工确认
		simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		simpleMessageListenerContainer.setMessageListener(firstMessageCoustom());
		return simpleMessageListenerContainer;
	}

	// 定义消息消费者
	@Bean
	public MessageCoustom firstMessageCoustom() {
		return new MessageCoustom();
	}

	/**
	 * 监听模式，当有消息到达队列时，会通知对应的监听对象
	 * @author ：biubiubiu小浩
	 * @date ：2018年7月19日 上午10:27:23 
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer secondSimpleMessageListenerContainer() {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(
				getConnectionFactory());
		// 设置监听队列
		simpleMessageListenerContainer.addQueues(secondQueue());
		simpleMessageListenerContainer.setExposeListenerChannel(true);
		// 并发消费者的最大数目
		simpleMessageListenerContainer.setMaxConcurrentConsumers(1);
		simpleMessageListenerContainer.setConcurrentConsumers(1);
		// 设置确认模式 手工确认
		simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		simpleMessageListenerContainer.setMessageListener(secondMessageCoustom());
		return simpleMessageListenerContainer;
	}

	// 定义消息消费者2号
	@Bean
	public SecondMessageCoustom secondMessageCoustom() {
		return new SecondMessageCoustom();
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(getConnectionFactory());
		/**
		 * 若使用confirm-callback或return-callback，必须要配置publisherConfirms或publisherReturns为true
		 * 每个rabbitTemplate只能有一个confirm-callback和return-callback
		 */
		rabbitTemplate.setReturnCallback(returnCallback());
		/**
		 * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，可针对每次请求的消息去确定’mandatory’的boolean值，
		 * 只能在提供’return -callback’时使用，与mandatory互斥
		 */
		// template.setMandatory(true);
		return rabbitTemplate;
	}

	@Bean
	public MessageReturnCallback returnCallback() {
		return new MessageReturnCallback();
	}
}
