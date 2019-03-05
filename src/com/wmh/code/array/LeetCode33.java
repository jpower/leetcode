package com.wmh.code.array;

/**
 * 搜索旋转排序数组
 * Created by 周大侠
 * 2019-02-16 12:04
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right ) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]) {
                if(nums[left] <= nums[mid] && target < nums[left]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                if(nums[left] >= nums[mid] && target > nums[right]) {
                    right = mid -1;
                }else {
                    left = mid + 1;
                }

            }
        }
        return -1;
    }
}
