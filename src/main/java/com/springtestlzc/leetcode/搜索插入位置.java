package com.springtestlzc.leetcode;

import java.util.Scanner;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 搜索插入位置 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for (int i =0;i<size;i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        searchInsert(nums,target);
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int max = nums.length-1;
        int mid;
        while (low < max) {
            mid = low + (max-low)/2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                max = mid -1;
            } else {
                low = mid;
            }
        }
        if (target <= nums[low]) {
            return low;
        } else return low+1;
    }
}
