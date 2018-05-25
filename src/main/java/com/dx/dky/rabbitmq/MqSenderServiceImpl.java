package com.dx.dky.rabbitmq;

import com.dx.dky.rabbitmq.config.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqSenderServiceImpl implements MqSenderService {

    @Autowired
    RabbitMqSender sender;

    @Override
    public void sendTopic(String routeKey, Object obj) {
        sender.sendRabbitmqTopic(routeKey, obj);
    }

    @Override
    public void sendDirect(String routeKey, Object obj) {
        sender.sendRabbitmqDirect(routeKey, obj);
    }
}
