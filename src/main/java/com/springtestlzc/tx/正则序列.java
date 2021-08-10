package com.springtestlzc.tx;

import java.util.Scanner;

public class 正则序列 {

    public static void main(String[] args) {
        /**
         * 我们称一个长度为n的序列为正则序列，当且仅当该序列是一个由1~n组成的排列，即该序列由n个正整数组成，取值在[1,n]范围，且不存在重复的数，同时正则序列不要求排序
         *
         * 有一天小团得到了一个长度为n的任意序列，他需要在有限次操作内，将这个序列变成一个正则序列，每次操作他可以任选序列中的一个数字，并将该数字加一或者减一。
         *
         * 请问他最少用多少次操作可以把这个序列变成正则序列？
         * 5
         * -1 2 3 10 100
         */

        Scanner sc = new Scanner(System.in);
        String strn = sc.nextLine();
        int n = Integer.parseInt(strn);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        int[] ints = new int[n];
        for (int i=0;i<strings.length; i++) {
            ints[i]= Integer.parseInt(strings[i]);
        }
        int x=0;
        for (int i=0;i<ints.length; i++) {
            x=Math.abs(1+i-ints[i]) + x;
        }
        System.out.println(x);
    }
}
