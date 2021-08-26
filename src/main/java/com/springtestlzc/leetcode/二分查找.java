package com.springtestlzc.leetcode;

import java.util.Scanner;

/**
 * 给定一个n个元素有序的（升序）整型数组ums 和一个目标值target ，
 * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二分查找 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for (int i =0;i<size;i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int low = 0,max = nums.length-1;
        int mid;
        while (low < max) {
            mid = (max+low)/2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                max = mid -1;
            } else {
                low = mid +1;
            }
        }
        if (target == nums[low]) {
            return low;
        } else
        return -1;
    }
}
