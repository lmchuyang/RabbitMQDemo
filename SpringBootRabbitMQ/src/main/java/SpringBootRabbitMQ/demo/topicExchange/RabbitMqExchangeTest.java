package SpringBootRabbitMQ.demo.topicExchange;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqExchangeTest {

    @Autowired
    private exchangeSender senders;

    @Test
    public void sendTest() throws Exception {
    	//发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息，发送send2只有topic.#可以匹配所有只有Receiver2监听到消息
    	//senders.send1("lmc");
    	//senders.send2("lmc-lsh");
    	senders.send3("lmc-ccc");
    }
}

