package SpringBootRabbitMQ.demo.topicExchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*Topic Exchange
topic 是RabbitMQ中最灵活的一种方式，可以根据routing_key自由的绑定不同的队列
首先对topic规则配置，这里使用两个队列来测试*/

@Configuration
public class TopicRabbitConfig {
	
	final static String message="topic.message";
	final static String messages = "topic.messages";
	final static String messagec = "topic.messagec";
	@Bean
	public Queue queueMessage(){
		return new Queue(TopicRabbitConfig.message);
	}
	
	@Bean
	public Queue queueMessages(){
		return new Queue(TopicRabbitConfig.messages);
	}
	@Bean
	public Queue queueMessagec(){
		return new Queue(TopicRabbitConfig.messagec);
	}
	@Bean
	TopicExchange exchange(){
		return new TopicExchange("exchange");//交换器
	}
	//使用queueMessages同时匹配两个队列，queueMessage只匹配"topic.message"队列
	//Queue queueMessage 对象必须是 队列Queue queueMessages() 方法名字
	@Bean
	Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}
	@Bean
	Binding bindingExchangeMessages(Queue queueMessages,TopicExchange exchange){
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
	}
	//把消息队列topic.messagec 绑定到topic.message 增加方法修改绑定队列就行，达到任意队列的绑定，下面就是把队列messagec绑定到message里
	//只需要调用message 队列的发送方法，就可以执行三个队列的生产者信息
	@Bean
	Binding bindingExchangeMessageC(Queue queueMessage,TopicExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.messagec");
	}
	//发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息，发送send2只有topic.#可以匹配所有只有Receiver2监听到消息
	
	@Bean
	Binding bindingExchangeMessageCs(Queue queueMessagec,TopicExchange exchange){//queueMessagec 这是重点，队列绑定
		return BindingBuilder.bind(queueMessagec).to(exchange).with("topic.messagec");
	}
}
