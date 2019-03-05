package com.wmh.code.dp;

/**
 * 打家劫舍
 * Created by 周大侠
 * 2019-02-14 21:06
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        if(nums.length==1) {
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-2] + nums[i], nums[i-1]);
        }
        return nums[nums.length-1];
    }
}
