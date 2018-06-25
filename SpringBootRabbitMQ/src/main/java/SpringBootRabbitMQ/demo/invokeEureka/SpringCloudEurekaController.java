package SpringBootRabbitMQ.demo.invokeEureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;

@RestController
public class SpringCloudEurekaController {

	@Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String home() {
        return "hello world";
    }

    @GetMapping("/message")
    public JSONObject getMessage() {
      /*  HelloMessage hello = getMessageFromHelloService();
        WorldMessage world = getMessageFromWorldService();
        HelloworldMessage helloworld = new HelloworldMessage();
        helloworld.setHello(hello);
        helloworld.setWord(world);
        log.debug("Result helloworld message:{}", helloworld);*/
    	JSONObject hello = getMessageFromHelloService();
        return hello;
    }

    private JSONObject getMessageFromHelloService() {
        //HelloMessage hello = restTemplate.getForObject("http://hello/message", HelloMessage.class);
    	JSONObject param = new JSONObject();
    	param.put("carID", "苏K77888");
    	//用注册服务调用微服务
        JSONObject hello = (JSONObject) restTemplate.getForObject("http://microservice-elefdata-service/getelefdata/cancelTask?str="+param,JSONObject.class);
        System.out.println(hello.toString());
        return hello;
    }

    /*private WorldMessage getMessageFromWorldService() {
        WorldMessage world = restTemplate.getForObject("http://world/message", WorldMessage.class);
        log.debug("From world service : {}.", world);
        return world;
    }*/
}
