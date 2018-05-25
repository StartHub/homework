package com.dx.dky.strategy.cash;

/**
 * 收费抽象类
 */
public abstract class CashSuper {

    // 当参数为原价时，返回当前价
    abstract double accptCash(double money);
}
