package com.wmh.code.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和三
 * Created by 周大侠
 * 2019-02-17 13:51
 */
public class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        dfs(res, temp, 1, n, k);
        return new ArrayList(res);
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int j, int n, int k) {
        if(n < 0 ){
            return;
        }
        if(n == 0 && temp.size() == k){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = j; i <= 9; i++) {
            temp.add(i);
            dfs(res, temp, i + 1, n - i, k);
            temp.remove(temp.size() - 1);
        }
    }
}
