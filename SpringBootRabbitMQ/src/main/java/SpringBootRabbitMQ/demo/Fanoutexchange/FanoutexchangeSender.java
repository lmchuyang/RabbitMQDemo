package SpringBootRabbitMQ.demo.Fanoutexchange;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//消息发送者,封装对象
@Component
public class FanoutexchangeSender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send1(String str){
		String context = "Fanout exchange lmc " + new Date()+str;
        System.out.println("Sender send1: " +context+str);
		this.amqpTemplate.convertAndSend("fanoutexchange","",context);
	}
}
