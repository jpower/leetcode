package com.wmh.code.tree;

import com.wmh.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的的序列化和反序列化
 * Created by 周大侠
 * 2019-02-07 15:32
 */
public class LeetCode297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "#,";
        }
        String res = root.val+",";
        res+=serialize(root.left);
        res+=serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        Queue<String> queue = new LinkedList();
        for(String element : datas){
            queue.add(element);
        }
        return fun(queue);
    }
    public TreeNode fun(Queue<String> queue) {
        String val = queue.poll();
        if("#".equals(val)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = fun(queue);
        node.right = fun(queue);
        return node;
    }
}
