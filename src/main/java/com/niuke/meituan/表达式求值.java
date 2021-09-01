package com.niuke.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给出一个布尔表达式的字符串，比如：true or false and false，表达式只包含true，false，and和or，
 * 现在要对这个表达式进行布尔求值，计算结果为真时输出true、为假时输出false，不合法的表达时输出error（比如：true true）。
 * 表达式求值是注意and 的优先级比 or 要高，比如：true or false and false，等价于 true or (false and false)，计算结果是 true。
 */
public class 表达式求值 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

    }

    public static String boolPanduan(String s) {
        String[] strs = s.split(" ");
        String[] andOr = new String[]{"and","or"};
        String[] trueFalse = new String[]{"true","false"};
        if (strs.length%2 == 0) {
            return "error";
        }
        if (strs.length == 1 && Arrays.asList(andOr).contains(strs[0])) {
            return "error";
        } else if("true".equals(strs[0])) {
            return "true";
        } else if ("false".equals(strs[0])) {
            return "false";
        }

        if (Arrays.asList(andOr).contains(strs[0]) || Arrays.asList(andOr).contains(strs[strs.length-1])) {
            return "error";
        }
        boolean flag = true;
        for (int i=1;i<strs.length-1;i++) {
            if ("and".equals(strs[i])
                    && !(Arrays.asList(andOr).contains(strs[i-1])
                    && Arrays.asList(andOr).contains(strs[i+1]))) {
                if ("true".equals(strs[i-1])) {
                    flag = ("true".equals(strs[i + 1]) ? true : false);
                }
            } else {
                return "error";
            }
        }
        return "true";
    }
}
