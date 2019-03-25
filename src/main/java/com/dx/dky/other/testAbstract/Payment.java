package com.dx.dky.other.testAbstract;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-09-27 11:28
 **/
public class Payment extends AbstractPayMent {

    @Override
    public boolean preHandle(String flag, ErrorMsg errorMsg) {

        if("1".equals(flag)){
            errorMsg.setMsg("我的flag是1");
            return true;
        }else {
            errorMsg.setMsg("我的flag是2");
            return false;
        }
    }
}
