package com.wmh.code.array;

/**
 * 寻找旋转数组中的最小值
 * Created by 周大侠
 * 2019-02-21 15:38
 */
public class LeetCode156 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int temp = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + ((right-left) >> 1);
            if(nums[left] < nums[mid]) {
                if(nums[left] < temp) {
                    temp = nums[left];
                }
                left = mid +1;
            }else if(nums[left] > nums[mid]) {
                if(nums[mid] < temp) {
                    temp = nums[mid];
                }
                right = mid - 1;
            }else {
                if(nums[mid] < temp) {
                    temp = nums[mid];
                }
                left = mid +1;
            }

        }
        return temp;
    }
    public static boolean isPalindrome(int x) {
        if(x == Integer.MIN_VALUE) {
            return false;
        }
        x = Math.abs(x);
        int help = 1;
        while(x / help >= 10) {
            help *= 10;
        }
        while(x!= 0) {
            if(x / help != x % 10) {
                return false;
            }

            x = (x % help) / 10;
            help /= 100;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
