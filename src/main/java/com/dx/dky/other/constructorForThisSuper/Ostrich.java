package com.dx.dky.other.constructorForThisSuper;

/**
 * @Descrintion:
 * @Author: dengxu
 * @Date: Created in 12:02 2018/9/8
 */

public class Ostrich extends Bird
{
//    public void fly()	//可以把子类中的这个方法注释掉，然后再编译执行，就可以看出子类继承父类的方法。此时在子类中用Ostrich对象调用fly方法就会出现“wo hui fei”
//    {
//        System.out.println("wo hui pao");
//        super.fly();	//调用子类继承过来的方法
//    }

//    Ostrich(){
//        this.fly();
//    }

    public static void main(String[] args)
    {
        Ostrich os = new Ostrich();
        os.fly();	//子类重写了父类中的方法，这里调用的是子类自己的方法。
    }
}
