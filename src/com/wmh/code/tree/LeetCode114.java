package com.wmh.code.tree;


import com.wmh.TreeNode;

/**
 * Created by 周大侠
 * 2019-02-07 20:29
 */

public class LeetCode114 {
    /**
     * 将二叉树退化成链表
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null){
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode next = root.right;
            while(next.right!=null){
                next = next.right;

            }
            next.right = right;
        }

    }
}
