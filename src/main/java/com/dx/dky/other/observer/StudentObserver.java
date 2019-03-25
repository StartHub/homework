package com.dx.dky.other.observer;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-03-22 15:25
 **/
public class StudentObserver implements Observer {

    private TeacherSubject subject;

    private String name;

    public StudentObserver(TeacherSubject t, String name){
        this.subject = t;
        this.name = name;
        t.addObserver(this);
    }

    @Override
    public void update(String info) {
        System.out.println(name + "得到作业：" + info);
    }
}
