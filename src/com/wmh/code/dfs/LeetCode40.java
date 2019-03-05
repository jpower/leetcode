package com.wmh.code.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和Ⅱ
 * Created by 周大侠
 * 2019-02-17 13:40
 */
public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList();
        dfs(res, temp, 0, nums, target);
        return new ArrayList(res);
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int j, int[] nums, int target) {
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList(temp));
        }
        for(int i = j; i < nums.length; i++) {
            if(i > j && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            dfs(res,temp,i + 1,nums,target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
