package com.dx.leetcode;

import com.alibaba.fastjson.JSON;
import io.swagger.models.auth.In;

import java.util.*;

/**
 * @Author dx
 * @Date 2021/1/17 12:33
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class TowSum {

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 1, 7};
        int target = 8;
        invokeTowSum1(nums, target);
        invokeTowSum2(nums, target);
    }

    private static void invokeTowSum1(int[] nums, int target) {

        long start = System.currentTimeMillis();

        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> indexArray = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int otherNum = target - nums[i];
            if (map.containsKey(otherNum)) {
                int[] arr = new int[]{map.get(otherNum), i};
                indexArray.add(arr);
            }

            map.put(nums[i], i);
        }

        System.out.print(System.currentTimeMillis() - start);
        System.out.println(JSON.toJSONString(indexArray));
    }

    private static void invokeTowSum2(int[] nums, int target) {
        long start = System.currentTimeMillis();

        List<int[]> indexArray = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 1; j < nums.length; j++) {

                if (i != j && nums[i] + nums[j] == target) {
                    int[] arr = new int[]{i, j};
                    indexArray.add(arr);
                }
            }
        }
        System.out.print(System.currentTimeMillis() - start);
        System.out.println(JSON.toJSONString(indexArray));
    }

}
