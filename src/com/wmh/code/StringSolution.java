package com.wmh.code;

import java.util.Arrays;
import java.util.Map;

import java.util.HashMap;

/**
 * Created by 周大侠
 * 2019-01-30 16:50
 */
public class StringSolution {
    /**
     * 242 有效的字母异味词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }

        return true;

    }

    /**
     * leetcode 7整数反转
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        String s = new StringBuilder(x + "").reverse().toString();
        char[] ch = s.toCharArray();
        if (ch[0] == '0') {
            s.substring(1);
        }
        if (ch[ch.length - 1] == '-') {
            s = s.replace("-", "");
            s = "-" + s;
        }

        Long i = Long.valueOf(s);
        if (i < Integer.MIN_VALUE || i > Integer.MAX_VALUE) {
            return 0;
        }
        int b = Math.toIntExact(i);
        return b;


    }

    /**
     * leetcode 125
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("\\W+|_+", "").toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(s1);
        return s1.equals(stringBuilder.reverse().toString());
    }

    /**
     * leetcode 28
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle == "") {
            return 0;
        }
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }

        return -1;

    }

    /**
     * leetcode 387 找到字符串中第一个不重复的字符
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < ch.length; i++) {

            if (!map.containsKey(ch[i])) {
                map.put(ch[i], 1);
            } else {
                map.put(ch[i], 2);
            }
        }

        for (int i = 0; i < ch.length; i++) {
            if (map.get(ch[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * leetcode 344 反转字符串
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }

    }

    /**
     * 交换字符数组中的顺序
     *
     * @param s
     * @param i1
     * @param i2
     */
    public void swap(char[] s, int i1, int i2) {
        s[i1] ^= s[i2];
        s[i2] ^= s[i1];
        s[i1] ^= s[i2];

    }
}
