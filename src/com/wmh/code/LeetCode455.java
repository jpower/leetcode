package com.wmh.code;

import java.util.Arrays;

/**
 *
 * Created by 周大侠
 * 2019-02-11 10:48
 */
public class LeetCode455 {
    /**
     * 分发饼干
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for(int i = res; i<s.length; i++) {
            for(int j = res; j<g.length ; j++) {
                if(s[i] >= g[j]) {
                    res++;
                }
                break;
            }
        }
        return res;
    }
}
