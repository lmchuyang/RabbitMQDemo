package SpringBootRabbitMQ.demo.rabbitObject;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import SpringBootRabbitMQ.demo.rabbit.User;

//消息接收者
@Component
public class HelloReceiverObject {
	
	@RabbitHandler
	@RabbitListener(queues="test_object")
	public void process(User user){
		 System.out.println("ReceiverObject: "+user.getId()+" === "+user.getName());
	}
}
