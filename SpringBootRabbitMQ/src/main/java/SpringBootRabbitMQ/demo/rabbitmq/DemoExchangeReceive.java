package SpringBootRabbitMQ.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//消息接收者
@Component
public class DemoExchangeReceive {
	
	@RabbitHandler
	@RabbitListener(queues="test_lmc_queue")
	public void processMessage(Object obj){
		//UserDTO user = (UserDTO) obj;
		// System.out.println(" test_lmc_queue: age: "+user.getAge()+" ======== name: "+user.getName());
		System.out.println("test_lmc_queue: ");
		System.out.println("DemoExchangeReceive--- test_lmc_queue: "+obj.toString());
	}
}

