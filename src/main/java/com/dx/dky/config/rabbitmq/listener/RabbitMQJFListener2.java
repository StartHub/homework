package com.dx.dky.config.rabbitmq.listener;

import com.dx.dky.config.rabbitmq.config.RabbitmqQueue;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 消费者消息确认
 *
 *
 *
 */
@Component
public class RabbitMQJFListener2 {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQJFListener2.class);

    @RabbitListener(queues = RabbitmqQueue.CONTRACE_JF_MSGINFO)
    public void jFHandler(String obj, Channel channel, Message message) throws IOException {

        logger.info("【homework】---->>>>>>>开始处理JF消息");
        System.out.println(obj);
        logger.info("【homework】---->>>>>>>JF消息处理结束");

        //手动确认配置
        //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

}
