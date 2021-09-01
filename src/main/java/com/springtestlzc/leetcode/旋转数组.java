package com.springtestlzc.leetcode;

public class 旋转数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
    }

    public static void rotate(int[] nums, int k) {
        int[] nums2 = new int[nums.length];
        int j = k%nums.length;
        for (int i=0;i<nums.length;i++) {
            if (i+j < nums.length) {
                nums2[i+j] = nums[i];
            } else {
                nums2[i+j-nums.length] = nums[i];
            }
        }
        nums =nums2;
        System.out.println(nums);
        System.arraycopy(nums2, 0, nums, 0, nums.length);
    }
}
