package com.springtestlzc.leetcode;

/**
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class 两数之和II_输入有序数组 {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(numbers,target));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int top = numbers.length -1;
        while (low<top) {
            if (numbers[low] + numbers[top] == target) {
                return new int[]{low+1,top+1};
            } else if (numbers[low] + numbers[top] < target) {
                low++;
            } else {
                top--;
            }
        }
        return null;
    }
}
