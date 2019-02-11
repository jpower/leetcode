package com.wmh.code;

import java.util.Stack;

/**
 * 基本计算器的实现
 * Created by 周大侠
 * 2019-02-11 10:18
 */
public class LeetCode224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int res = 0;
        int sym = 1;
        char[] ch = s.toCharArray();
        for(int i = 0; i<ch.length; i++){
            if(ch[i]==' '){
                continue;
            }
            if(ch[i]>'0') {
                int num = 0;
                while(i<ch.length&&ch[i]>='0') {
                    num = num * 10 + (ch[i]-'0');
                    i++;
                }
                res = res + sym * num;
                i--;
            }else if(ch[i] == '+') {
                sym = 1;
            }else if(ch[i] == '-') {
                sym = -1;
            }else if(ch[i] == '(') {
                stack.push(res);
                stack.push(sym);
                res = 0;
                sym = 1;
            }else if(ch[i] == ')') {
                sym = stack.pop();
                res = stack.pop()+sym*res;
            }

        }
        return res;
    }
}
