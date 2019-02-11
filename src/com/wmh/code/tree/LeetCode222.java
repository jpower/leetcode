package com.wmh.code.tree;

import com.wmh.TreeNode;

/**
 * 计算完全二叉树的节点个数
 * Created by 周大侠
 * 2019-02-09 10:18
 */
public class LeetCode222 {
    int hight = 0;
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        hight = selectTier(root);
        return countNodes(root,1);
    }
    public int countNodes(TreeNode node, int tier) {
        if (tier == hight) {//如果level来到最后一层，就是叶子节点
            return 1;
        }
        if(selectTier(node.right)==hight-tier){
            return (1 << (hight-tier)) + countNodes(node.right,tier+1);
        }else{
            return (1 << (hight-tier-1)) + countNodes(node.left,tier+1);
        }
    }
    public int selectTier(TreeNode node) {
        int count = 0;
        while(node!=null) {
            count++;
            node = node.left;
        }
        return count;
    }
}
