package com.wmh.code.dp;

import java.util.List;

/**
 * 三角形最小路径和
 * Created by 周大侠
 * 2019-02-15 17:46
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> nums) {

        int rows = nums.size();
        if(rows == 0) {
            return 0;
        }
        List<Integer> endRow = nums.get(rows-1);
        int length = endRow.size();
        int[][] dp = new int[rows + 1][length + 1];
        // 如果开辟数组的长度-1 需要进行下面的操作 把最后一行初始化
        // for(int i = 0; i < length; i++) {
        //     dp[rows-1][i] = endRow.get(i);
        // }
        for(int i = rows - 1; i >= 0; i--) {
            List<Integer> row = nums.get(i);
            for(int j = 0; j < row.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + row.get(j);
            }
        }
        return dp[0][0];
    }
}
