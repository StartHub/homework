package com.dx.dky.other.strategy.cash;

/**
 * 客户端使用
 */
public class CashTest {

    public static void main(String[] args) {

        // 正常收费
        CashContext cashContext = new CashContext(1);
        double rs = cashContext.getResult(500);
        System.out.println(rs);

        cashContext = new CashContext(2);
        double rs2 = cashContext.getResult(500);
        System.out.println(rs2);

        cashContext = new CashContext(3);
        double rs3 = cashContext.getResult(500);
        System.out.println(rs3);

    }



}
