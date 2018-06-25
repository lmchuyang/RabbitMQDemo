package SpringBootRabbitMQ.demo.rabbit;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//消息发送者
@Component
public class Sender2 {

	@Autowired
	private AmqpTemplate amqpTemplate;
	public void send(String message){
		String context = "hello world lmc " + new Date();
        System.out.println("Sender2 : " + context+message);
		this.amqpTemplate.convertAndSend("hello_lmctest",context);
	}
}
