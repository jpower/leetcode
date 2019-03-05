package com.wmh.code.array;

/**
 * Created by 周大侠
 * 2019-02-13 15:49
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
