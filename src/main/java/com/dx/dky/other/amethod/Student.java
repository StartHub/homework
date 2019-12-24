package com.dx.dky.other.amethod;

/**
 * @author : dengxu
 * @create 2019-11-19 10:52
 **/
public class Student extends Person implements IStudyable {

    private static int cnt = 5;

    static {
        cnt++;
    }

    private String sid;

    public Student(String name, int age, String sid) {
        super(name, age);
        this.sid = sid;
    }

    @Override
    public void run() {
        System.out.println("run()...");
    }

    @Override
    public int study(int a, int b) {

        int c = 10;
        int d = 20;
        return a + b * c - d;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void main(String[] args) {
        Student s = new Student("dqrcsc", 23, "20150723");
        s.study(5, 6);
        Student.getCnt();
        s.run();
    }
}
