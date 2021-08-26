package com.springtestlzc.tx;

import java.util.Scanner;

public class 字母出现次数 {
    /**
     * 描述
     * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写，字符串长度小于500。
     *
     * 输入描述：
     * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
     *
     * 输出描述：
     * 输出输入字符串中含有该字符的个数。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strs = scanner.nextLine();
        String str = scanner.nextLine();
        strs = strs.toUpperCase();
        str = str.toUpperCase();
        char[] charstrs = strs.toCharArray();
        char[] charstr = str.toCharArray();
        int count = 0;
        for (int i=0;i<charstrs.length;i++) {
            if (charstr[0] == charstrs[i])
                count++;
        }
        System.out.println(count);
    }
}
