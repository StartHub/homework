//package com.dx.dky.config.rabbitmq.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 新增业务时，两个步骤
// * 1、增加 queue bean ，参照queueXXXX方法
// * 2增加 queue 和 exchange的binding,参照 bindingExchangeXXXX方法(topic类似于模糊查询，对不同的routekey中特定关键词进行消费)
// *
// */
//@Configuration
//@AutoConfigureAfter(RabbitMqConfig.class)
//public class RabbitMqExchangeConfig {
//
//    /*************   开始 Exchange 交换机 定义  *******************/
//    /**
//     * 主题型 交换机
//     * 默认:durable = true, autoDelete = false
//     *
//     * @param rabbitAdmin
//     * @return
//     */
//    @Bean
//    TopicExchange contractTopicExchangeDurable(RabbitAdmin rabbitAdmin) {
//        TopicExchange contractTopicExchange = new TopicExchange(RabbitmqExchange.CONTRACT_TOPIC);
//        rabbitAdmin.declareExchange(contractTopicExchange);
//        return contractTopicExchange;
//    }
//
//    /**
//     * 直连型交换机
//     */
//    @Bean
//    DirectExchange contractDirectExchange(RabbitAdmin rabbitAdmin) {
//        DirectExchange contractDirectExchange = new DirectExchange(RabbitmqExchange.CONTRACT_DIRECT);
//        rabbitAdmin.declareExchange(contractDirectExchange);
//        return contractDirectExchange;
//    }
//
//    /*************   开始 Queue队列  定义  *******************/
//
//    /**
//     * durable 持久化参数 true 持久化 false 不持久化
//     * @param rabbitAdmin
//     * @return
//     */
//    @Bean
//    Queue queueJf(RabbitAdmin rabbitAdmin) {
//        Queue queue = new Queue(RabbitmqQueue.CONTRACE_JF_MSGINFO, true);
//        rabbitAdmin.declareQueue(queue);
//        return queue;
//    }
//
//    @Bean
//    Queue queueUserJF(RabbitAdmin rabbitAdmin) {
//        Queue queue = new Queue(RabbitmqQueue.USER_JF, true);
//        rabbitAdmin.declareQueue(queue);
//        return queue;
//    }
//
//    @Bean
//    Queue queueUserYH(RabbitAdmin rabbitAdmin) {
//        Queue queue = new Queue(RabbitmqQueue.USER_YH, true);
//        rabbitAdmin.declareQueue(queue);
//        return queue;
//    }
//
//    /*************   开始  将 queue 绑定到 指定交换机   *******************/
//
//    @Bean
//    Binding bindingExchangeJF(Queue queueJf, DirectExchange exchange, RabbitAdmin rabbitAdmin) {
//        Binding binding = BindingBuilder.bind(queueJf).to(exchange).with(RabbitmqQueue.CONTRACE_JF_MSGINFO);
//        rabbitAdmin.declareBinding(binding);
//        return binding;
//    }
//
////    @Bean
////    Binding bindingExchangeJF(Queue queueJf, TopicExchange exchange, RabbitAdmin rabbitAdmin) {
////        Binding binding = BindingBuilder.bind(queueJf).to(exchange).with(RabbitmqQueue.CONTRACE_JF_MSGINFO);
////        rabbitAdmin.declareBinding(binding);
////        return binding;
////    }
//
//}