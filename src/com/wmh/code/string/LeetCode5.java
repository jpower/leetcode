package com.wmh.code.string;

/**
 * 最长回文字串
 * Created by 周大侠
 * 2019-02-19 15:00
 */
public class LeetCode5 {
    /**
     * 以每个中心点 判断以该点为中心的字符串是否为回文串 一共有2*length -1 个中心点
     * 遍历中心点 判断回文串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < 2 * s.length() - 1; i++) {
            int left = i / 2;
            int right = i / 2 +1;
            if(i % 2 == 0) {
                left--;
            }
            String str = plalindrome(s, left, right);
            if(str.length() > res.length()) {
                res = str;
            }
        }
        return res;
    }
    public String plalindrome(String s, int left, int right) {

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
