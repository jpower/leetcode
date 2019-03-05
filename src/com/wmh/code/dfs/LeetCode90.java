package com.wmh.code.dfs;

import java.util.*;

/**
 * 求子集Ⅱ 数组包含重复元素 只要将数组 排序 并且将结果变成不重复的集合 就可避免 元素一样 顺序相同 和 元素一样 顺序不同 两种重复情况
 * Created by 周大侠
 * 2019-02-16 15:22
 */
public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList();
        res.add(temp);
        fun(nums, 0, res, temp);
        return new ArrayList(res);
    }
    public void fun(int[] nums, int i, Set<List<Integer>> res, List<Integer> temp) {
        if(i == nums.length) {
            return;
        }
        temp.add(nums[i]);
        res.add(new ArrayList(temp));
        fun(nums, i + 1, res, temp);
        temp.remove(temp.size()-1);
        fun(nums, i + 1, res, temp);

    }
}
