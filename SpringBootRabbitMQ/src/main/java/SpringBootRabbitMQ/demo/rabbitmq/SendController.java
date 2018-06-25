package SpringBootRabbitMQ.demo.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;





/**
 * 测试controller
 * @Controller 和  @ResponseBody 等价 @RestController
 * @author 
 *
 */
@Controller 
@RequestMapping("/rabbbit")
public class SendController{  
  
    @Autowired  
    private Sender<UserDTO> sender;  
  
    @RequestMapping("/direct")  
    @ResponseBody
    public String direct(){
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(24);
        userDTO.setName("alibaba");
        sender.send(userDTO);
        return "消息处理成功";  
    }  
    
}
