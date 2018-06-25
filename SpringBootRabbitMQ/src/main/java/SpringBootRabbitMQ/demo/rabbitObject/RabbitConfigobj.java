package SpringBootRabbitMQ.demo.rabbitObject;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfigobj {
	
	// 交换器模式创建的时候，要注释其它创建的 消息队列
/*	@Bean
	public Queue helloQueueObject(){
		  return new Queue("test_object");
	}*/
}
