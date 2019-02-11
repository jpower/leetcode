package com.wmh.code.tree;

import com.wmh.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 验证二叉完全数
 * Created by 周大侠
 * 2019-02-09 8:08
 */
public class LeetCode958 {
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) {
            return true;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode l = node.left;
            TreeNode r = node.right;
            if((l == null && r != null) ||
                    (flag && (l != null || r != null))) {
                return false;
            }
            if(l != null) {
                queue.add(l);
            }
            if(r != null) {
                queue.add(r);
            }else {
                flag = true;
            }
        }
        return true;
    }
}
