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
        int[] initData = {11, 12, 13, 20, 21, 32, 38, 43, 59, 65, 66, 76, 98, 99};
        int searchNum = 32;
        int start = 0;
        int end = initData.length - 1;
        // todo 先对数组元素进行排序 但排序之后获取当前元素的索引位置就不是原数组元素的下标位置
//        initData = Arrays.stream(initData).sorted().toArray();
        System.out.println(Arrays.toString(initData));
//        while (true){
//            int midIndex = (start + end) / 2;
//            int currentNum = initData[midIndex];
//            if(currentNum == searchNum){
//                System.out.println(midIndex);
//                break;
//            }else if(currentNum > searchNum){
//                end = midIndex - 1;
//            }else {
//                start = midIndex + 1;
//            }
//            if(start > end){
//                System.out.println("cannot find search element!!!");
//                break;
//            }
//        }

        //递归查找
        System.out.println(searchNum + "索引位置为：" + binarySearchNum(initData, searchNum, start, end));
    }

    /**
     * 递归二分法查找
     * 时间复杂度    T(n) = O(log2n)
     * 空间复杂度    S(n) = O(log2n)
     * @param initData
     * @param searchNum
     * @param start
     * @param end
     * @return
     */
    private static int binarySearchNum(int[] initData, int searchNum, int start, int end) {
        int mid = (start + end) / 2;
        if(start > end){
            return -1;
        }
        if(searchNum == initData[mid]){
            return mid;
        }else if(searchNum > initData[mid]){
            return binarySearchNum(initData, searchNum, mid + 1, end);
        }else {
            return binarySearchNum(initData, searchNum, start, mid - 1);
        }
    }
}
