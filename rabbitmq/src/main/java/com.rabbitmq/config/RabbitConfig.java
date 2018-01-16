package com.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Created by jiangchengyi on 2018/1/16.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue () {
        return new Queue("hello");
    }
}
