package com.wmh.code.dp;

import java.util.List;

/**
 * 单词拆分
 * Created by 周大侠
 * 2019-02-17 16:13
 */

/**
 *      if  S[0,i]在dictionary里面 dp[i] = true 
 *
 *      if   possible[k] == true 并且 S[k+1,i]在dictionary里面， 0<k<i   = true 
 *
 *      if    no such k exist.  = false 
 * ---------------------
 */
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        char[] ch = s.toCharArray();
        for(int i = 0; i < dp.length; i++) {
            if(wordDict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            }else {
                for(int j = 0; j < i; j++) {
                    if(dp[j] && wordDict.contains(s.substring(j+1,i+1))) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()-1];

    }
}
