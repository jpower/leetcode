package com.wmh.code.tree;

import com.wmh.TreeNode;

/**
 * 从后序遍历和中序遍历构造二叉树
 * Created by 周大侠
 * 2019-02-20 0:11
 */
public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        if(inEnd < inStart || postEnd < postStart ) {
            return null;
        }
        TreeNode root = new TreeNode(post[postEnd]);
        for(int i = inStart; i <= inEnd; i++) {
            if(in[i] == post[postEnd]) {
                root.left = buildTree(in, inStart, i-1, post, postStart, postEnd - (inEnd - i) -1);
                root.right = buildTree(in, i + 1, inEnd, post, postEnd - inEnd - i, postEnd - 1 );
                break;
            }
        }
        return root;

    }
}
