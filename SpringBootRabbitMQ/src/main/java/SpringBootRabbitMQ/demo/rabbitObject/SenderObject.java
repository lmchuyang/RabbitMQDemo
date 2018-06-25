package SpringBootRabbitMQ.demo.rabbitObject;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SpringBootRabbitMQ.demo.rabbit.User;


//消息发送者,封装对象
@Component
public class SenderObject {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(User user){
		String context = "hello object lmc " + new Date();
        System.out.println("Sender object: " +user.toString());
		this.amqpTemplate.convertAndSend("test_object",user);
	}	
}
