package com.example.rabbitmqdemo.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: dingwenlong
 * @Title: Producer
 * @ProjectName: rabbitMQdemo
 * @Description:
 * @date: 2022/4/14 17:41
 */
public class Producer {


        private final static String QUEUE_NAME = "hello";

        public static void main(String[] args) throws IOException, TimeoutException {
            // 创建连接
            ConnectionFactory factory = new ConnectionFactory();
            // 设置 RabbitMQ 的主机名
            factory.setHost("192.168.12.128");
            // 创建一个连接
            Connection connection = factory.newConnection();
            // 创建一个通道
            Channel channel = connection.createChannel();
            // 指定一个队列,不存在的话自动创建
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 发送消息
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            // 关闭频道和连接
            channel.close();
            connection.close();
        }


}
