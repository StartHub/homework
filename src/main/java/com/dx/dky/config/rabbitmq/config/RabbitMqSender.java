//package com.dx.dky.config.rabbitmq.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.UUID;
//
///**
// * 生产者消息确认
// *  RabbitTemplate.ConfirmCallback 消息确认监听器
// *  RabbitTemplate.ReturnCallback  消息发送失败返回监听器
// */
//@Component
//public class RabbitMqSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqSender.class);
//
//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    public RabbitMqSender(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//        //
//        this.rabbitTemplate.setConfirmCallback(this);
//    }
//
//    /**
//     * 发送到 指定routekey的指定queue
//     *
//     * @param routeKey
//     * @param obj
//     */
//    public void sendRabbitmqDirect(String routeKey, Object obj) {
//        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
//        LOGGER.info("send: " + correlationData.getId());
//        this.rabbitTemplate.convertAndSend(RabbitmqExchange.CONTRACT_DIRECT, routeKey, obj, correlationData);
//    }
//
//    /**
//     * 所有发送到Topic Exchange的消息被转发到所有关心RouteKey中指定Topic的Queue上
//     *
//     * @param routeKey
//     * @param obj
//     */
//    public void sendRabbitmqTopic(String routeKey, Object obj) {
//        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
//        LOGGER.info("send: " + correlationData.getId());
//        this.rabbitTemplate.convertAndSend(RabbitmqExchange.CONTRACT_TOPIC, routeKey, obj, correlationData);
//    }
//
//    /**
//     * 回调方法
//     * 实现ConfirmCallback
//     * ACK=true仅仅标示消息已被Broker接收到，并不表示已成功投放至消息队列中
//     * ACK=false标示消息由于Broker处理错误，消息并未处理成功
//     */
//    @Override
//    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        System.out.println("消息id:" + correlationData.getId());
//        if (ack) {
//            LOGGER.info("send message success: " + correlationData.getId());
//        } else {
//            LOGGER.info("send message failed: " + cause + correlationData.toString());
//        }
//    }
//
//    @Override
//    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//        LOGGER.info("收到回调");
//        LOGGER.info("return--message:" + new String(message.getBody()) + ",replyCode:" + replyCode + ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
//    }
//}
