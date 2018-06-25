package SpringBootRabbitMQ.demo.rabbitObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import SpringBootRabbitMQ.demo.rabbit.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTestObject {

    @Autowired
    private SenderObject senderobj;

    @Test
    public void hello() throws Exception {
    	//消息发送对象类型，一定要序列化才行
    	 User user=new User();
    	user.setId("1243");
    	user.setName("lmc");
    	System.out.println("user");
    	for(int i=0;i<6;i++){
    		senderobj.send(user);
    	}
    }
}

