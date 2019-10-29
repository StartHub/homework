package com.dx.dky.other;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-09-14 11:27
 **/
public class CD2 {
    public static void main(String args[]){
        Chicken c = new Chicken();
        Egg e = new Egg();

        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(3));
    }
}

class Chicken{
    private Egg e;
    private int age ;
    public Chicken(){
        e = new Egg() ;
        setAge(10) ;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
class Egg{
    private Chicken chicken;
    private int weight ;
    public Egg(){
        chicken = new Chicken();
        setWeight(1) ;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}

