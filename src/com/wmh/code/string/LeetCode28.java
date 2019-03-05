package com.wmh.code.string;

/**
 * Created by 周大侠
 * 2019-02-18 23:08
 */
public class LeetCode28 {
    /**
     * 判断字符串是否为另一字符串的连续字串
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int a = haystack.length();
        int b = needle.length();
        for(int i = 0; i <= a-b; i++) {
            boolean flag = true;
            for(int j = 0; j < b; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return i;
            }
        }
        return -1;
    }
}
