package SpringBootRabbitMQ.demo.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//消息接收者，以一个queues  多个接收者同处理
//一个发送者，N个接受者,经过测试会均匀的将消息发送到N个接收者中
@Component

public class HelloReceiver {
	
	@RabbitHandler
	@RabbitListener(queues="hello_lmctest")
	public void process(String str){
		 System.out.println(String.format("receive message: %s", str));;
	}
	@RabbitHandler
	@RabbitListener(queues="hello_lmctest")
	public void proBack(String str){
		 System.out.println(String.format("receive proBack: %s", str));;
	}
}
