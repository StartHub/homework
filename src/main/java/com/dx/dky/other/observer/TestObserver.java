package com.dx.dky.other.observer;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-03-22 15:32
 **/
public class TestObserver {

    public static void main(String[] args) {

        TeacherSubject teacher = new TeacherSubject();

        StudentObserver zhangsan = new StudentObserver(teacher, "zhangsan");
        StudentObserver lisi = new StudentObserver(teacher, "lisi");
        StudentObserver wangwu = new StudentObserver(teacher, "wangwu");

        teacher.setHomework("今天每个汉字写三行！");
    }
}
