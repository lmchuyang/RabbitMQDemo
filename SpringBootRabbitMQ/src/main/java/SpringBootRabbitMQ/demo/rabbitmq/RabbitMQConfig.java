package SpringBootRabbitMQ.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;



/**
 * rabbitmq核心配置
 * @author 
 *
 */
@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.host}")
    public String host;
    @Value("${spring.rabbitmq.port}")
    public int port;
    @Value("${spring.rabbitmq.username}")
    public String username;
    @Value("${spring.rabbitmq.password}")
    public String password;
    @Value("${spring.rabbitmq.virtual-host}")
    public String virtualHost;
    @Value("${spring.rabbitmq.publisher-confirms}")
    public Boolean  publisherConfirms;

    /**
     * 创建工厂，自动创建的ConnectionFactory不能完成事件的回调
     * 
     * @return
     */
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setPublisherConfirms(publisherConfirms);//手动应答模式
        return connectionFactory;
    }

    /**
     * RabbitTemplate 发送消息，必须是prototype类型，
     * 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置
     * 
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        
        /**若使用confirm-callback或return-callback，
         * 必须要配置publisherConfirms或publisherReturns为true  
         * 每个rabbitTemplate只能有一个confirm-callback和return-callback
         * */  
        template.setConfirmCallback(msgSendConfirmCallBack());  
        template.setReturnCallback(msgSendReturnCallback()); 
        
        /**  
         * 使用return-callback时必须设置mandatory为true，
         * 或者在配置中设置mandatory-expression的值为true，
         * 可针对每次请求的消息去确定’mandatory’的boolean值，  
         * 只能在提供’return -callback’时使用，与mandatory互斥
         * */  
         template.setMandatory(true); //保证消息的可靠投递
        return template;
    }

    /**
     * 消息确认机制
     * Confirms给客户端一种轻量级的方式，能够跟踪哪些消息被broker处理，
     * 哪些可能因为broker宕掉或者网络失败的情况而重新发布。
     * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。
     * (两者不可同时使用)在channel为事务时，
     * 不可引入确认模式；同样channel为确认模式下，不可使用事务。
     * 
     */
    @Bean  
    public MsgSendConfirmCallBack msgSendConfirmCallBack(){  
        return new MsgSendConfirmCallBack();  
    }

    /**
     * 消息未发送到交换机调用
     * @return
     */
    @Bean
    public MsgSendReturnCallback msgSendReturnCallback(){
        return new MsgSendReturnCallback();
    }
    
    @Bean
    public Queue defaultQueue() {
        return new Queue(RabbitMqQueue.QUEUE, true); // 队列持久
    }

    /**
     * 针对消费者配置 FanoutExchange: 将消息分发到所有的绑定队列，
     * 无routingkey的概念 HeadersExchange
     * ：通过添加属性key-value匹配 DirectExchange:按照routingkey分发到指定队列
     * TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(RabbitMqExchange.EXCHANGE);
    }

    /**
     * 通过绑定键将队列绑定到指定的交换机上
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(defaultQueue()).to(defaultExchange()).with(RabbitMqRoutingKey.ROUTINGKEY);
    }


}
