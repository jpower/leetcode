package com.wmh.code.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词模式
 * Created by 周大侠
 * 2019-02-18 11:49
 */
public class LeetCode290 {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        Map<Character,String> map = new HashMap();
        if(strs.length != pattern.length()) {
            return false;
        }
        for(int i = 0; i < strs.length; i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            }else {
                if(map.containsValue(strs[i])) {
                    return false;
                }
                map.put(pattern.charAt(i),strs[i]);
            }
        }
        return true;
    }
}
