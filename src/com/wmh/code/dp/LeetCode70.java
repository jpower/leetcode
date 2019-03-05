package com.wmh.code.dp;

/**
 * 爬樓梯
 * Created by 周大侠
 * 2019-02-14 15:10
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        // 暴力递归
//         if(n == 1) {
//             return 1;
//         }
//         if(n == 2) {
//             return 2;
//         }


//         return climbStairs(n-1) + climbStairs(n-2);

        // 动态规划
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
