package com.wmh.code.dp;

/**
 * 地下城游戏
 * Created by 周大侠
 * 2019-02-15 16:27
 */
public class LeetCode174 {
    public int calculateMinimumHP(int[][] nums) {
        int y = nums.length;
        if(y == 0) {
            return 0;
        }
        int x = nums[0].length;
        int[][] dp = new int[y][x];
        dp[y-1][x-1] = Math.max(1, 1 - nums[y - 1][ x - 1]);
        for(int i = x - 2 ; i >= 0; i--) {
            dp[y - 1][i] = Math.max(1, dp[y - 1][i + 1] - nums[y - 1][i]);
        }
        for(int i = y - 2 ; i >= 0; i--) {
            dp[i][x - 1] = Math.max(1, dp[i + 1][x - 1] - nums[i][x - 1]);
        }
        for(int i = y - 2; i >= 0; i--) {
            for(int j = x - 2; j >= 0; j--) {
                int dpMin = Math.min(dp[i + 1][j],dp[i][j + 1]);
                dp[i][j] = Math.max(1, dpMin - nums[i][j]);
            }
        }
        return dp[0][0];
    }
}
