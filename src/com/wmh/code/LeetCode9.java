package com.wmh.code;

/**
 * 判断一个整数 是否为回文数
 * Created by 周大侠
 * 2019-02-21 16:15
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if(x == Integer.MIN_VALUE || x < 0) {
            return false;
        }
        int help = 1;
        while(x / help >= 10) {
            help *= 10;
        }
        while(x > 0) {
            if(x / help != x % 10) {
                return false;
            }
            x = (x % help) / 10;
            help /= 100;
        }
        return true;
    }
}
