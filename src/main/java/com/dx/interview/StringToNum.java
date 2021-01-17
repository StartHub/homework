package com.dx.interview;

/**
 * @Author dx
 * @Date 2021/1/9 16:54
 * @Description  TODO 123转为321
 */
public class StringToNum {

    public static void main(String[] args) {

        int num = 123;

        StringBuilder sb = new StringBuilder("");
        while (num % 10 > 0){
            sb.append(num % 10);
            num = num / 10;
        }
        System.out.println(sb.toString());


    }
}
