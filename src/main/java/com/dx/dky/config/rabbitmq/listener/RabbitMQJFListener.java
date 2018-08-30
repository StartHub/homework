package com.dx.dky.config.rabbitmq.listener;

import com.dx.dky.config.rabbitmq.config.RabbitmqQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQJFListener {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQJFListener.class);

    @RabbitListener(queues = RabbitmqQueue.CONTRACE_JF_MSGINFO)
    public void jFHandler(String obj) {

        logger.info("【homework】---->>>>>>>开始处理JF消息");
        System.out.println(obj);
        logger.info("【homework】---->>>>>>>JF消息处理结束");
    }

}
