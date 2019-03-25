package com.dx.dky.other.observer;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-03-22 15:16
 **/
public interface Subject {

    void addObserver(Observer observer);

    void delObserver(Observer observer);

    void notifyObserver();
}
