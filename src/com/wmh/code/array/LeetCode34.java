package com.wmh.code.array;

/**
 * 在包含重复元素的排序数组中 查找目标元素的第一个位置和最后一个位置
 * Created by 周大侠
 * 2019-02-15 20:28
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int befor = -1;
        int after = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(target == nums[mid]){
                if(mid == 0 || nums[mid - 1] < target) {
                    befor = mid;
                    break;
                }
                end = mid - 1;
            }else if(target > nums[mid]) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        start = 0;
        end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(target == nums[mid]){
                if(mid == nums.length - 1 || nums[mid + 1] > target) {
                    after = mid;
                    break;
                }
                start = mid + 1;
            }else if(target > nums[mid]) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return new int[]{befor,after};
    }

}
