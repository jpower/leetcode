package com.wmh.code.tree;

import com.wmh.TreeNode;

/**
 * 二叉树的最近公共祖先
 * Created by 周大侠
 * 2019-02-22 14:49
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left !=null && right!=null) {
            return root;
        }
        return left != null ? left : right;

    }
}
