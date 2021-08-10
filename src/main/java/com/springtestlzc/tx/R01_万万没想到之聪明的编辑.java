package com.springtestlzc.tx;

import java.util.Scanner;

public class R01_万万没想到之聪明的编辑 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < line; i++) {
            System.out.println(scanner.nextLine().replaceAll("(.)\\1+","$1$1").replaceAll("(.)\\1(.)\\2","$1$1$2"));
        }
        /*Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        while(N-- > 0){
            String str = sc.nextLine();
            StringBuilder s = new StringBuilder(str);
            for(int i = 0; i + 2 < s.length(); ++i){
                char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2);
                if(a == b && b == c) s.deleteCharAt(i--);
            }
            for(int i = 0; i + 3 < s.length(); ++i){
                char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2), d = s.charAt(i + 3);
                if(a == b && c == d) s.deleteCharAt(i + 3);
            }
            System.out.println(s);
        }*/

    }
}
