package com.wmh.code.string;

import java.util.HashSet;

/**
 * 无重复的最长字串 窗口法
 * Created by 周大侠
 * 2019-02-18 19:03
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        int walker = 0;
        int runner = 0;
        while(runner<s.length()) {
            if(!set.contains(s.charAt(runner))) {
                set.add(s.charAt(runner));
                max = Math.max(max,runner-walker+1);
            } else {
                while(s.charAt(walker)!=s.charAt(runner)) {
                    set.remove(s.charAt(walker));
                    walker++;
                }
                walker++;
            }
            runner++;
        }
        return max;
    }
}
