package SpringBootRabbitMQ.demo.topicExchange;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SpringBootRabbitMQ.demo.rabbit.User;


//消息发送者,封装对象
@Component
public class exchangeSender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	//路由键与队列无关，绑定队列才是关键 topic.MC
	public void send1(String str){
		String context = "exchange lmc " + new Date()+str;
        System.out.println("Sender send1: " +context+str);
		this.amqpTemplate.convertAndSend("exchange","topic.MA",context);
	}
	public void send2(String str){
		String context = "exchange lmc " + new Date()+str;
        System.out.println("Sender send2: " +context);
		this.amqpTemplate.convertAndSend("exchange","topic.messages",context);
	}
	public void send3(String str){
		String context = "exchange lmc " + new Date()+str;
        System.out.println("Sender send3: " +context);
		this.amqpTemplate.convertAndSend("exchange","topic.messagec",context);
	}
}
