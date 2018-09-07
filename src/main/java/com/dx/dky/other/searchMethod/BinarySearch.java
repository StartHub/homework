package com.dx.dky.other.searchMethod;

import java.util.Arrays;

/**
 * 注：1.数组需要先排序
 *    2.确定最左下标值start，和最右下标值end
 *    3.在无限循环中，start和end值在不断变化
 *    4.当start和end交叉时，确定找不到所需元素
 * @author : dengxu
 * @create 2018-09-04 15:07
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] initData = {21, 13, 38, 98, 12, 76, 32, 20, 59, 11, 43, 66, 65, 99};
        int searchNum = 32;
        int start = 0;
        int end = initData.length - 1;
        // todo 先对数组元素进行排序 但排序之后获取当前元素的索引位置就不是原数组元素的下标位置
        initData = Arrays.stream(initData).sorted().toArray();
        while (true){
            int midIndex = (start + end) / 2;
            int currentNum = initData[midIndex];
            if(currentNum == searchNum){
                System.out.println(midIndex);
                break;
            }else if(currentNum > searchNum){
                end = midIndex - 1;
            }else {
                start = midIndex + 1;
            }
            if(start > end){
                System.out.println("cannot find search element!!!");
                break;
            }
        }
    }
}
