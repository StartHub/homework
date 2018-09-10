package com.dx.dky.other.constructorForThisSuper;

/**
 * @Descrintion:
 * @Author: dengxu
 * @Date: Created in 11:53 2018/9/8
 */
public class ConstructorTest {

    public String name;
    public int count;
    public double weight;

    public ConstructorTest(String name) {
        this.name = name;
    }

    public ConstructorTest(String name, int count) {
        this(name);        //调用形式参数列表为name的重载构造器初始化代码。
        this.count = count;
    }

    public ConstructorTest(String name, int count, double weight) {
        this(name, count);        //调用形式参数列表为name,count的重载构造器初始化代码。
        this.weight = weight;
    }

    public static void main(String[] args) {
        ConstructorTest con = new ConstructorTest("Nina");
        System.out.println(con.name);
        System.out.println(con.count);
        System.out.println(con.weight);
        System.out.println("__________________________________");

        ConstructorTest con1 = new ConstructorTest("Fengqiang", 333);
        System.out.println(con1.name);
        System.out.println(con1.count);
        System.out.println(con1.weight);
        System.out.println("__________________________________");

        ConstructorTest con2 = new ConstructorTest("okay", 333, 1.2345);
        System.out.println(con2.name);
        System.out.println(con2.count);
        System.out.println(con2.weight);
    }
}
