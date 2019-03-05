package com.wmh.code.array;

/**
 * 往排序数组里插入元素 返回该插入位置
 * Created by 周大侠
 * 2019-02-17 21:36
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while(start < end) {
            int mid = (start + end) / 2;
            if(target <= nums[mid]) {
                end = mid;
            }else if(target > nums[mid]) {
                start = mid + 1;
            }

        }
        return start;
    }
}
