package SpringBootRabbitMQ.demo.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRabbitMqExchangeTest {

    @Autowired  
    private Sender<UserDTO> sender;  
    @Test
    public void sendTest() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(25);
        userDTO.setName("alibaba");
        sender.send(userDTO);
    }
}

