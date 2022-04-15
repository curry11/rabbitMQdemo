package com.example.rabbitmqdemo.rabbitmq.service;

/**
 * @author: dingwenlong
 * @Title: RabbitMQConsumerService  生产者
 * @ProjectName: rabbitMQdemo
 * @Description:
 * @date: 2022/4/15 11:42
 */
public interface RabbitMQConsumerService {

    String sendMessage(String message);
}
