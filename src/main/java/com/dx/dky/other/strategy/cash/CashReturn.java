package com.dx.dky.other.strategy.cash;

/**
 * 返利收费类
 */
public class CashReturn extends CashSuper {

    private double moneyCondition = 0.0d;

    private double moneyReturn = 0.0d;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    double accptCash(double money) {

        double result = money;

        if( money >= moneyCondition){
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        }

        return result;
    }
}
