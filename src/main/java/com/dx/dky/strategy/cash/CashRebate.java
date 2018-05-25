package com.dx.dky.strategy.cash;

/**
 * 打折收费类
 */
public class CashRebate extends CashSuper {

    public double moneyRebate = 1d;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    double accptCash(double money) {
        return money * moneyRebate;
    }
}
