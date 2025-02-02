package com.gyt.springbootamqp;

import com.gyt.springbootamqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));

//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));

        // 创建binding
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
                Binding.DestinationType.QUEUE, "amqpadmin.exchange",
                "amqp.haha", null));


        System.out.println("创建完成");
    }


    /**
     * 1. 单播（点对点）
     */
    @Test
    public void contextLoads() {
        // message需要自己定义
//        rabbitTemplate.send(exchange, routKey, message);

        // 只需要传入要发送的对象，自动序列化并发送
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "hello");
        map.put("data", Arrays.asList("hello", 123, true));
        // 默认序列化后发送
        rabbitTemplate.convertAndSend("exchange.direct", "gyt.news", new Book("大数据", "gyt"));

    }

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("gyt.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦", "aa"));
    }
}
