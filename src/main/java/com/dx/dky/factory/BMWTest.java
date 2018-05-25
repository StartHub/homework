package com.dx.dky.factory;

public class BMWTest {

    public static void main(String[] args) {

        BMWFactory factory = new BMWFactory();
        BMW bmw320 = factory.makeByType(320);
        BMW bmw523 = factory.makeByType(523);
    }
}
