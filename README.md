# RabbitMQDemo
rabbitMQ消息服务管理，生产者消费者一些模式开发，测试的 docker容器运行项目


先熟悉下面会用到的一些名词~

exchange： 交换机

routingkey: 路由key

queue: 队列

exchange和queue是需要绑定在一起的，然后消息发送到exchange再由exchange通过routingkey发送到对应的队列中。


exchange分四种

Default Exchange
这种是特殊的Direct Exchange，是rabbitmq内部默认的一个交换机。该交换机的name是空字符串，所有queue都默认binding 到该交换机上。所有binding到该交换机上的queue，routing-key都和queue的name一样。

注意： 这就是为什么你直接创建一个queue也能正常的生产与消费，因为对应的exchange是RabbitMQ默认的，routingkey就是该队列的名字

Topic Exchange
通配符交换机，exchange会把消息发送到一个或者多个满足通配符规则的routing-key的queue。其中表号匹配一个word，#匹配多个word和路径，路径之间通过.隔开。如满足a..c的routing-key有a.hello.c；满足#.hello的routing-key有a.b.c.helo。

Fanout Exchange
扇形交换机，该交换机会把消息发送到所有binding到该交换机上的queue。这种是publisher/subcribe模式。用来做广播最好。 所有该exchagne上指定的routing-key都会被ignore掉。

Header Exchange
设置header attribute参数类型的交换机。

简单的了解之后，下面就是延迟队列的实现方式

延迟队列的实现
延迟分两种

在msg上设置过期时间
在队列上设置过期时间

