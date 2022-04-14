package com.example.rabbitmqdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: dingwenlong
 * @Title: HelloWorldConfig
 * @ProjectName: rabbitMQdemo
 * @Description:
 * @date: 2022/4/14 18:44
 */
@Configuration
public class HelloWorldConfig {

    public static final String HELLO_WORLD_QUEUE_NAME = "hello_world_queue";

//    @Bean
//    Queue queue1() {
//        return new Queue(HELLO_WORLD_QUEUE_NAME);
//    }

}
