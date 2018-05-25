package com.dx.dky.strategy;

public class Context {

    private IStrategy iStrategy;

    public IStrategy getiStrategy() {
        return iStrategy;
    }

    public void setiStrategy(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void operator() {
        this.iStrategy.operator();
    }

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

}
