package com.springtestlzc.tx;

import java.util.Scanner;

public class 最后一个单词的长度 {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String strn = sc.nextLine();
        String[] strings = strn.split(" ");
        System.out.println(strings[strings.length-1].length());*/

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i)==' ') { // 或者 if (str.substring(i, i + 1).equals(" ")) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
