package com.wmh.code.dp;

/**
 * 最大子序和
 * Created by 周大侠
 * 2019-02-14 21:00
 */
public class LeetCode53 {
    /**
     * 动态规划 需要知道以i元素结尾的最大序列和以i-1元素结尾的关系
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] > 0 ? (nums[i-1] + nums[i]) : nums[i];
            res = nums[i] > res ? nums[i] : res;
        }
        return res;

    }
    // 暴力枚举 速度很慢 O(N2)
    // int maxSum = nums[0];
    // for(int i = 0; i < nums.length; i++) {
    //     int sum = 0;
    //     for(int j = i; j < nums.length; j++) {
    //         sum += nums[j];
    //         if(sum > maxSum) {
    //             maxSum = sum;
    //         }
    //     }
    // }
    // return maxSum;

}
