package SpringBootRabbitMQ.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import SpringBootRabbitMQ.demo.mqmany.Sender;
import SpringBootRabbitMQ.demo.mqmany.Sender2;
import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		
   /* 	JSONObject param = new JSONObject();
    	param.put("carID", "苏K77888");
    	//用注册服务调用微服务
        JSONObject hello = (JSONObject) restTemplate.getForObject("http://microservice-elefdata-service/getelefdata/cancelTask?str="+param,JSONObject.class);
        System.out.println(hello.toString());*/
	}
	
	@Autowired
    private Sender sender;

    @Autowired
    private Sender2 sender2;

    @Test
    public void hello() throws Exception {
        sender.send1();
       // sender.send2();
    }

    @Test
    public void hello2() throws Exception {
       // sender2.send1();
        sender2.send2();
    }

}
