package SpringBootRabbitMQ.demo.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//消息接收者,多个接收者
/*@Component
@RabbitListener(queues="hello_lmctest")
public class HelloReceiverone {
	
	@RabbitHandler
	public void process(String str){
		 System.out.println(String.format("receive HelloReceiverone", str));;
	}
}
*/