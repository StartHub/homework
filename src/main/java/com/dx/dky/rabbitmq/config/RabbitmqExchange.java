package com.dx.dky.rabbitmq.config;

/**
 * exchange交换机配置
 */
public interface RabbitmqExchange {

    public final String CONTRACT_FANOUT = "CONTRACT_FANOUT";

    public final String CONTRACT_TOPIC = "CONTRACT_TOPIC";

    public final String CONTRACT_DIRECT = "CONTRACT_DIRECT";
}