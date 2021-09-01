package com.springtestlzc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class 有序数组的平方 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums= new int[]{-4,-1,0,3,10};
        sortedSquares(nums);
    }

    public static int[] sortedSquares(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i=0;i<nums.length;i++) {
            list.add(nums[i]*nums[i]);
        }
        Collections.sort(list);
        int[] nums2 = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            nums2[i] = list.get(i);
        }
        return nums2;
    }

    public int[] sortedSquares2(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    /**
     * 双指针
     * 可以使用两个指针分别指向位置 0 和 n-1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针。
     * @param nums
     * @return
     */
    public int[] sortedSquares3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }


}
