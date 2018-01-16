package com.rabbitmq.service.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by jiangchengyi on 2018/1/16.
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void procss (String hello) {
        System.out.println("hello = [" + hello + "]");
    }
}
