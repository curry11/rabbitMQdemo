package com.example.rabbitmqdemo.rabbitmq.service.imp;

import com.example.rabbitmqdemo.config.RabbitMQConfig;
import com.example.rabbitmqdemo.rabbitmq.service.RabbitMQConsumerService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: dingwenlong
 * @Title: RabbitMQConsumerServiceImp
 * @ProjectName: rabbitMQdemo
 * @Description:
 * @date: 2022/4/15 11:43
 */
@Service
public class RabbitMQConsumerServiceImp implements RabbitMQConsumerService {
    //日期格式化
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    private RabbitTemplate rabbitTemplate;


    @Override
    public String sendMessage(String message) {
        try {
            String msgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
            String sendTime = sdf.format(new Date());
            Map<String, Object> map = new HashMap<>();
            map.put("msgId", msgId);
            map.put("sendTime", sendTime);
            map.put("msg", message);
            rabbitTemplate.convertAndSend(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE, RabbitMQConfig.RABBITMQ_DEMO_DIRECT_ROUTING, map);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
