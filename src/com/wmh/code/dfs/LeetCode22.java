package com.wmh.code.dfs;

import java.util.ArrayList;

/**
 * 生成括号
 * Created by 周大侠
 * 2019-02-17 19:36
 */
public class LeetCode22 {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n <= 0)
            return res;
        helper(n, n, new String(), res);
        return res;
    }

    private void helper(int l, int r, String item, ArrayList<String> res) {
        if (r < l)
            return;
        if (l == 0 && r == 0) {
            res.add(item);
        }
        if (l > 0)
            helper(l - 1, r, item + "(", res);
        if (r > 0)
            helper(l, r - 1, item + ")", res);

    }
}
