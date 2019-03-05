package com.wmh.code.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * Created by 周大侠
 * 2019-02-17 0:35
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        boolean[] used =  new boolean[nums.length];
        dfs(nums, used, res, temp);
        return res;
    }
    public void dfs(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> temp) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]){
                temp.add(nums[i]);
                used[i] = true;
                dfs(nums, used, res, temp);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }



    }
}
