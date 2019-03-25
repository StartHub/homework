package com.dx.dky.other.testAbstract;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-09-27 11:23
 **/
public abstract class AbstractPayMent {

    public abstract boolean preHandle(String flag, ErrorMsg errorMsg);

    public void invoke(String flag){

        ErrorMsg errorMsg = new ErrorMsg();

        if(preHandle(flag, errorMsg)){
            System.out.println(errorMsg.getMsg());
        }else {
            System.out.println(errorMsg.getMsg());
        }


    }
}
