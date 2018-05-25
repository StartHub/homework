package com.dx.dky.strategy.cash;

/**
 * 策略与简单工厂结合：将实例化具体策略的过程由客户端转移到context
 */
public class CashContext {

    private CashSuper cashSuper;

    public CashContext(int cashType) {
        switch (cashType) {
            case 1:
                cashSuper = new CashNormal();// 正常收费
                break;
            case 2:
                cashSuper = new CashRebate(0.8);// 打八折
                break;
            case 3:
                cashSuper = new CashReturn(300, 100);// 满减
                break;
        }
    }

    public double getResult(double money){
        return cashSuper.accptCash(money);
    }
}
