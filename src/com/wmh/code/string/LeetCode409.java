package com.wmh.code.string;

/**
 * 最长回文子串
 * Created by 周大侠
 * 2019-02-18 15:36
 */
public class LeetCode409 {
    /**
     * 如果该字符出现的次数为偶数 则都可用来形成最长字串 如果为奇数 去掉一个
     * 最后判断如果最长字串长度小于字符串长度 随便拿去掉的一个来当中间的字符
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int sum = 0;
        int[] charSize = new int[123];
        for(int i = 0; i < s.length(); i++) {
            charSize[s.charAt(i)]+=1;
        }
        for(int i : charSize) {
            if(i % 2 == 0) {
                sum += i;
            }else{
                sum += i - 1;
            }
        }
        return sum < s.length() ? sum+1 : sum;
    }
}
