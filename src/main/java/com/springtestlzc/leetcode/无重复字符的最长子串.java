package com.springtestlzc.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        //System.out.println(lengthOfLongestSubstring(s));
        Map<String,Integer> m = new HashMap<>();
        m.put("a",1);
        m.put("b",2);
        m.put("a",3);
        for (Map.Entry<String,Integer> e : m.entrySet()){
            System.out.println(e.getKey()+";"+e.getValue());
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int low = -1,top = 0;
        for (int i=0;i<n;i++) {
            if (i!=0) {
                occ.remove(s.charAt(i-1));
            }
            while (low+1 < n && !occ.contains(s.charAt(low+1))) {
                occ.add(s.charAt(low+1));
                low++;
            }
            top = Math.max(top, low-i +1);
        }
        return top;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

}
