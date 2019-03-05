package com.wmh.code.dp;

/**
 * 最大上升子序列
 * Created by 周大侠
 * 2019-02-15 12:03
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int count = 0;
        for(int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j] && dp[j] +1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > dp[count]) {
                count = i;
            }
        }
        return dp[count];
    }

    public static void main(String[] args) {
        int[][] dp = new int[5][3];
        System.out.println(dp[0].length);
    }


}
