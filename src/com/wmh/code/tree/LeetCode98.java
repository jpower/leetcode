package com.wmh.code.tree;

import com.wmh.TreeNode;

import java.util.Stack;

/**
 * 用中序遍历验证二叉搜索树
 * Created by 周大侠
 * 2019-02-08 17:16
 */
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        long x = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (node.val <= x) {
                    return false;
                }
                x = node.val;
                root = node.right;
            }
        }
        return true;
    }

    //        递归算法，比较快
    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
    // 对于左子树，只有最大值是确定的=根节点，最小值小到多少无所谓。root.val是上一次递归的确定值
//          对于右子树，只有最小值是确定的=根节点，最大值大到多少无所谓
/*对于每个子树，都有一个最大值和一个最小值，
对于左子树，最大值就是它的根节点的值，最小值是根节点的最小值（左父亲或者MIN_VALUE）
对于右子树，最小值就是它的根节点的值，最大值是根节点的最大值（右父亲或者MAX_VALUE）*/

}
