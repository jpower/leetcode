package com.wmh.code.array;

/**
 * 第一个错误版本 二分查找
 * Created by 周大侠
 * 2019-02-21 21:26
 */
public class LeetCode278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
//        while(left < right) {
//            int mid = left + (right-left)/2;
//            if(isBadVersion(mid)) {
//                right = mid;
//            }else {
//                left = mid+1;
//            }

//        }
        return right;
    }
}
