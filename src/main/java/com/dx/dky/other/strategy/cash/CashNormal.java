package com.dx.dky.other.strategy.cash;

/**
 * 正常收费类
 */
public class CashNormal extends CashSuper {

    @Override
    double accptCash(double money) {
        return money;
    }
}
