package SpringBootRabbitMQ.demo.rabbit;

import java.io.Serializable;

//消息发送对象类型，一定要序列化才行
public class User implements Serializable{

	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
