package com.gyt.springbootamqp.service;

import com.gyt.springbootamqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "gyt.news")
    public void receive(Book book) {
        System.out.println("收到消息: " + book);
    }

    @RabbitListener(queues = "gyt")
    public void receive02(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
