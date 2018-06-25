package SpringBootRabbitMQ.demo.Fanoutexchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//消息接收者
@Component
public class FanoutexchangeReceive {
	
	@RabbitHandler
	@RabbitListener(queues="fanout.a")
	public void processMessage(String str){
		 System.out.println("processMessageA: "+str);
	}
	@RabbitHandler
	@RabbitListener(queues="fanout.b")
	public void processMessages(String str){
		 System.out.println("processMesssagesB: "+str);
	}
	@RabbitHandler
	@RabbitListener(queues="fanout.c")
	public void processMessagec(String str){
		 System.out.println("processMesssagescC: "+str);
	}
}

