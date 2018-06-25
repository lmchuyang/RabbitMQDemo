package SpringBootRabbitMQ.demo.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
	
	// 交换器模式创建的时候，要注释其它创建的 消息队列
/*	@Bean
	public Queue helloQueue(){
		  return new Queue("hello_lmctest");
	}*/

}
