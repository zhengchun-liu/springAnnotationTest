package com.niuke.bilibili;

import java.util.Scanner;

/**
 * 面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。
 * 现在小Y使用1024元的纸币购买了一件价值为N(0<N≤1024)的商品，请问最少他会收到多少硬币
 * 12个64元硬币，3个16元硬币，2个4元硬币
 */
public class houduan1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    public static int GetCoinCount (int N) {
        int l = 1024 - N;
        int num = 0;
        int num64 = 0;
        int num16 = 0;
        int num4 = 0;
        int num1 = 0;
        num = num64 = l/64;
        l = l - 64*num64;
        num16 = l/16;
        num = num + num16;
        l = l - 16*num16;
        num4 = l/4;
        num = num + num4;
        l = l- 4*num4;
        num1 = l;
        num = num1 + num;
        return num;
    }
}
