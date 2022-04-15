package com.example.rabbitmqdemo.rabbitmq.controller;

import com.example.rabbitmqdemo.rabbitmq.service.RabbitMQConsumerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: dingwenlong
 * @Title: RabbitMQController
 * @ProjectName: rabbitMQdemo
 * @Description:
 * @date: 2022/4/15 11:47
 */
@RestController
@RequestMapping("/consumer")
public class RabbitMQController {

    @Resource
    RabbitMQConsumerService rabbitMQConsumerService;

    @PostMapping("/sends")
    public String sends(@RequestParam(name = "msg") String msg) {
        return rabbitMQConsumerService.sendMessage(msg);
    }
}
