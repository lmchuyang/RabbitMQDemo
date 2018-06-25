package SpringBootRabbitMQ.demo.mqmany;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Resource(name="firstRabbitTemplate")
    private RabbitTemplate firstRabbitTemplate;

    public void send1() {
        String context = "hello1 " + new Date();
        System.out.println("firstRabbitTemplate Sender : " + context);
        this.firstRabbitTemplate.convertAndSend("hello1", context);
    }

 /*   public void send2() {
        String context = "hello2 " + new Date();
        System.out.println("firstRabbitTemplate  Sender : " + context);
        this.firstRabbitTemplate.convertAndSend("hello2", context);
    }*/

}