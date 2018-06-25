package SpringBootRabbitMQ.demo.mqmany;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "hello1", containerFactory="firstFactory")
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }

    @RabbitHandler
    @RabbitListener(queues = "hello2", containerFactory="secondFactory" )
    public void process2(String hello) {
        System.out.println("Receiver : " + hello);
    }
    
    
}