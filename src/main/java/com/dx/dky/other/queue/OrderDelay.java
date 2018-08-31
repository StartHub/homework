package com.dx.dky.other.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-08-31 9:55
 **/
public class OrderDelay implements Delayed {


    private String orderId;

    private long outTime;

    public OrderDelay(String orderId, long outTime) {
        this.orderId = orderId;
        this.outTime = outTime + System.nanoTime();    }

    /**
     * 距离自定义超时时间还有多久
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(outTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other) {

        if (other == this) {
            return 0;
        }

        if (other instanceof OrderDelay) {
        }

        OrderDelay orderDelay = (OrderDelay) other;
        long d = getDelay(TimeUnit.NANOSECONDS) - orderDelay.getDelay(TimeUnit.NANOSECONDS);

        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    void print() {
        System.out.println(orderId + "编号的订单要删除啦。。。。");
    }
}
