package SpringBootRabbitMQ.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
    private RestTemplate restTemplate;
	
	@Test
	public void contextLoads() {
    	JSONObject param = new JSONObject();
    	param.put("carID", "苏K77888");
    	//用注册服务调用微服务
        JSONObject hello = (JSONObject) restTemplate.getForObject("http://microservice-elefdata-service/getelefdata/cancelTask?str="+param,JSONObject.class);
        System.out.println(hello.toString());
	}

}
