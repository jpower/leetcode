package com.wmh.code.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求数组子集
 * Created by 周大侠
 * 2019-02-16 14:44
 */
public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        res.add(temp);
        dfs(res, temp, nums, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
        if (j == nums.length) {
            return;
        }

        temp.add(nums[j]);  //① 加入 nums[i]
        res.add(new ArrayList<Integer>(temp));
        dfs(res, temp, nums, j + 1);  //② 递归
        temp.remove(temp.size() - 1);  //③ 移除 nums[i]
        dfs(res, temp, nums, j + 1);  //② 递归
    }



}
