package SpringBootRabbitMQ.demo.Fanoutexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。

@Configuration
public class FanoutExchangeConfig {

	@Bean
	public Queue messageA(){
		return new Queue("fanout.a");
	}
	@Bean
	public Queue messageB(){
		return new Queue("fanout.b");
	}
	@Bean
	public Queue messageC(){
		return new Queue("fanout.c");
	}
	
	@Bean
	FanoutExchange fanoutExchange(){
		return new  FanoutExchange("fanoutexchange");
	}
	@Bean
	Binding bindingExchangeA(Queue messageA,FanoutExchange exchange){
			return BindingBuilder.bind(messageA).to(exchange);
	}
	@Bean
	Binding bindingExchangeB(Queue messageB,FanoutExchange exchange){
			return BindingBuilder.bind(messageB).to(exchange);
	}
	@Bean
	Binding bindingExchangeC(Queue messageC,FanoutExchange exchange){
			return BindingBuilder.bind(messageC).to(exchange);
	}
	
}
