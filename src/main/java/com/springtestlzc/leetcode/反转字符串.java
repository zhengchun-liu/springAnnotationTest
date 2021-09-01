package com.springtestlzc.leetcode;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */
public class 反转字符串 {
    public static void main(String[] args) {
        StringBuffer B = new StringBuffer("hello");
        System.out.println(B.reverse());
//        String ss = "hello";
//        char[] a = ss.toCharArray();
//        reverseString(a);
    }

    public static void reverseString(char[] s) {
        int low = 0,top = s.length-1;
        char a;
        while (low < top) {
            a = s[low];
            s[low] = s[top];
            s[top] = a;
            low++;
            top--;
        }
        for (char c : s) {
            System.out.println(c);
        }
    }
}
