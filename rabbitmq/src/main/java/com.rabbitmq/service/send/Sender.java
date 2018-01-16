package com.rabbitmq.service.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jiangchengyi on 2018/1/16.
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hellow"+ new Date();
        System.out.println("context: " + context);

        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
