package com.wmh.code.tree;

import com.wmh.TreeNode;

/**
 * 已知前序中序遍历 求整棵树
 * Created by 周大侠
 * 2019-02-19 22:57
 */
public class LeetCode105 {
    public TreeNode buildTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd ) {
        if(preEnd < preStart || inEnd < inStart) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for(int i = inStart; i <= inEnd; i++) {
            if(in[i] == pre[preStart]) {
                root.left = reConstructBinaryTree(pre, preStart+1, i - inStart + preStart, in, inStart, i-  1);
                root.right = reConstructBinaryTree(pre, preStart + i - inStart +1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }
}
