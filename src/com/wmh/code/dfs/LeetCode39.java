package com.wmh.code.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 * Created by 周大侠
 * 2019-02-17 11:06
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        dfs(res, temp, 0, nums, target);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int j, int[] nums, int target) {
        int sum = sum(temp,0);
        if(sum > target){
            return;
        }
        if(sum == target){
            res.add(new ArrayList(temp));
        }
        for(int i = j; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(res,temp,i,nums,target);
            temp.remove(temp.size() - 1);
        }
    }
    public int sum(List<Integer> list, int i) {
        if(i == list.size() ) {
            return 0;
        }
        return list.get(i) + sum(list, i+1);
    }
}
