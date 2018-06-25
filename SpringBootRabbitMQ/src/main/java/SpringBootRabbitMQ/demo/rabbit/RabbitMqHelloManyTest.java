package SpringBootRabbitMQ.demo.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//多个发送者一个接收者，均匀接收发来的消息，
//一个发送者，N个接受者,经过测试会均匀的将消息发送到N个接收者中
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloManyTest {

    @Autowired
    private Sender1 senders1;
    @Autowired
    private Sender2 senders2;

    @Test
    public void hello() throws Exception {
    //多个发送都 和多个接收者，交替均匀处理消息，	
    //多个发送者和一个接收者，(接收者要收到多个发送者 的消息，每一个都 要消费)
    //一个发送者和多个接收者(，接收者会均匀的去消费，发送者的消息，消费者总和跟发送者一致，如多线程执行任务一样)
    	for(int i=0;i<50;i++){
    		senders1.send(String.format("hi(%d)", i + 1));
    		senders2.send(String.format("hi(%d)", i + 1));
    	}
    	
    }
}

