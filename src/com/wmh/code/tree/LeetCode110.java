package com.wmh.code.tree;

import com.wmh.TreeNode;

/**
 * Created by 周大侠
 * 2019-02-08 16:20
 */
public class LeetCode110 {
    /**
     * 判断一棵树是否为平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        int hight = hight(root);
        return hight==-1 ? false : true;
    }
    public int hight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHight = hight(root.left);
        int rightHight = hight(root.right);
        if(leftHight==-1||rightHight==-1){
            return -1;
        }

        if(Math.abs(leftHight-rightHight)>1){
            return -1;
        }
        return Math.max(leftHight,rightHight)+1;
    }
}
