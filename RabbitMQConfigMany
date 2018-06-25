package SpringBootRabbitMQ.demo.mqmany;


import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * rabbitmq核心配置
 * @author 
 *
 */
@Configuration
public class RabbitMQConfigMany {

	//绑定多台服务器的参数
    @Bean(name="firstConnectionFactory")
    //@Primary标签指若不指定链接，默认选择链接，在配置了多个链接必须添加@Primary标签，否则有可能会找不到对应的rabbitMQ的连接。
    //spring注解@primaryg两个相同实例必须优生注入一个,否则会报错
    @Primary
    public ConnectionFactory firstConnectionFactory(
                                            @Value("${spring.rabbitmq.first.host}") String host, 
                                            @Value("${spring.rabbitmq.first.port}") int port,
                                            @Value("${spring.rabbitmq.first.username}") String username,
                                            @Value("${spring.rabbitmq.first.password}") String password
                                            ){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }
    
    @Bean(name="secondConnectionFactory")
    public ConnectionFactory secondConnectionFactory(
                                            @Value("${spring.rabbitmq.second.host}") String host, 
                                            @Value("${spring.rabbitmq.second.port}") int port,
                                            @Value("${spring.rabbitmq.second.username}") String username,
                                            @Value("${spring.rabbitmq.second.password}") String password
                                            ){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }
    
    //拿到服务器配置模板 发送消息和绑定到哪台服务器上
    @Bean(name="firstRabbitTemplate")
    public RabbitTemplate firstRabbitTemplate(
                                            @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory
                                            ){
        RabbitTemplate firstRabbitTemplate = new RabbitTemplate(connectionFactory);
        return firstRabbitTemplate;
    }
    
    @Bean(name="secondRabbitTemplate")
    public RabbitTemplate secondRabbitTemplate(
                                            @Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory
                                            ){
        RabbitTemplate secondRabbitTemplate = new RabbitTemplate(connectionFactory);
        return secondRabbitTemplate;
    }
    
    //处理消息的时候，拿到哪个服务器配置去处理
    @Bean(name="firstFactory")
    public SimpleRabbitListenerContainerFactory firstFactory(
                                                        SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                        @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory        
                                                        ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }
    @Bean(name="secondFactory")
    public SimpleRabbitListenerContainerFactory secondFactory(
                                                        SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                        @Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory           
                                                        ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }
    
	@Bean
    public String firstQueue(
            @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory
    ) {
        System.out.println("configuration firstQueue ........................");
        //return new Queue("hello1");
        try {
            connectionFactory.createConnection().createChannel(false).queueDeclare("hello1", false, false, false, null);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return "firstQueue";
        }
    }
 
	@Bean
    public String secondQueue(
            @Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory
    ) {
        System.out.println("configuration secondQueue ........................");
        //return new Queue("hello2");
        try {
             connectionFactory.createConnection().createChannel(false).queueDeclare("hello2", false, false, false, null);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return "secondQueue";
        }
    }
    
  
}
