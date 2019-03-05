package com.wmh.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计算当前数的右侧比当前数小的个数
 * Created by 周大侠
 * 2019-02-17 21:24
 */
public class LeetCode315 {
    public List<Integer> countSmaller(int[] arr) {

        //排序数组
        List<Integer> temp = new ArrayList<>();
        //结果数组
        Integer[] res = new Integer[arr.length];

        //原数组从后向前遍历，根据二分法升序插入到新数组
        for(int i=arr.length-1;i>=0;i--){
            int left = 0,right = temp.size();
            while(left<right){
                int mid =left+(right-left)/2;
                if(temp.get(mid)>=arr[i]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            //新数组对应位置的下标即为原数组右侧小于该数的个数
            res[i] = left;
            temp.add(left,arr[i]);
        }
        return Arrays.asList(res);
    }

}
