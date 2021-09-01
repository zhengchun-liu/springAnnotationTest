package com.niuke.bilibili;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个只包含括号的字符串，判断字符串是否有效。其中，括号种类包含： ‘(’，’)’，’{’，’}’，’[’，’]'。
 * 有效字符串需满足：
 * 1) 左括号必须用相同类型的右括号闭合；
 * 2）左括号必须以正确的顺序闭合。注意空字符串可被认为是有效字符串
 */
public class bilibilihouduan2 {

    public static void main(String[] args) {
        IsValidExp("{[]}");
    }

    public static boolean IsValidExp (String s) {
        /*Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '[') stack.push(']');
            else if(ch == '(') stack.push(')');
            else if(ch == '{') stack.push('}');
            else if(stack.isEmpty() || !stack.pop().equals(ch)) return false;
        }
        return stack.isEmpty();*/

        if(s.length()==1)return false;
        LinkedList list=new LinkedList();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
                list.add(s.charAt(i));
            if(s.charAt(i)==')'){
                if(list.size()==0)return false;
                char a=(char)list.pollLast();
                if(a!='(')return false;
            }
            if(s.charAt(i)==']'){
                if(list.size()==0)return false;
                char a=(char)list.pollLast();
                if(a!='[')return false;
            }
            if(s.charAt(i)=='}'){
                if(list.size()==0)return false;
                char a=(char)list.pollLast();
                if(a!='{')return false;
            }



        }
        return true;
    }
}
