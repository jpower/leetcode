package com.wmh.code.dp;

/**
 * 零钱兑换
 * Created by 周大侠
 * 2019-02-15 17:56
 */
public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 0; i <= amount; i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1){
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1){
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}
