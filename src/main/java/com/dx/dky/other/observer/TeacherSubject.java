package com.dx.dky.other.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-03-22 15:20
 **/
public class TeacherSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    private String info;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        if(observers.indexOf(observer) > 0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {

        for (Observer observer : observers){
            observer.update(info);
        }
    }

    public void setHomework(String info) {
        this.info = info;
        System.out.println("今天的作业是：" + info);
        notifyObserver();
    }
}
