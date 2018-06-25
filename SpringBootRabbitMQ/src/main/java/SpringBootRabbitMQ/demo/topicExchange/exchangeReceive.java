package SpringBootRabbitMQ.demo.topicExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//消息接收者
@Component
public class exchangeReceive {
	
	@RabbitHandler
	@RabbitListener(queues="topic.message")
	public void processMessage(String str){
		 System.out.println("processMessage1: "+str);
	}
	@RabbitHandler
	@RabbitListener(queues="topic.messages")
	public void processMessages(String str){
		 System.out.println("processMesssages2: "+str);
	}
	@RabbitHandler
	@RabbitListener(queues="topic.messagec")
	public void processMessagec(String str){
		 System.out.println("processMesssagesc3: "+str);
	}
}

