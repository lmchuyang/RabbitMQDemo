package SpringBootRabbitMQ.demo.rabbitmq;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 发送者
 * @author 
 *
 * @param <E>
 */
@Component
public class Sender<E> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 消息发送
     * @param e
     */
    public void send(Object e) {

        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMqExchange.EXCHANGE, RabbitMqRoutingKey.ROUTINGKEY, e,correlationId);
    }

}


