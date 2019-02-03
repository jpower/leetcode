package com.wmh.code;

/**
 * Created by 周大侠
 * 2019-02-03 10:31
 */
public class LeetCode75 {
    /**
     * 荷兰国旗问题
     * @param nums
     */
    public void sortColors(int[] nums) {
        int less = -1;
        int more = nums.length;
        int index = 0;
        while(index < more) {
            if(nums[index] == 1){
                index++;
            }else if(nums[index]<1){
                swap(nums,index++,++less);
            }else{
                swap(nums,index,--more);
            }

        }
    }
    public void swap(int[] arr,int a,int b){
        if(a==b) return;
        arr[a] ^=arr[b];
        arr[b] ^=arr[a];
        arr[a] ^=arr[b];
    }
}
