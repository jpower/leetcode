package com.wmh.code.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * 字母异位词分组
 * Created by 周大侠
 * 2019-02-18 15:04
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if(map.containsKey(str)) {
                map.get(str).add(strs[i]);
            }else{
                List<String> list = new ArrayList();
                list.add(strs[i]);
                map.put(str,list);

            }
        }
        List<List<String>> res = new ArrayList();
        for(String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;

    }
}
