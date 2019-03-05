package com.wmh.code.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * Created by 周大侠
 * 2019-02-17 1:12
 */
public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();

        List<Integer> temp = new ArrayList();
        dfs(res,n,k,1,temp);
        return res;
    }
    public void dfs(List<List<Integer>> res, int n, int k,int i, List<Integer> temp) {
        if(temp.size() == k) {
            res.add(new ArrayList(temp));
        }
        for(int j = i; j <= n; j++) {
            temp.add(j);
            dfs(res,n,k,j+1,temp);
            temp.remove(temp.size()-1);
        }

    }
}
