/**
 * Baidu.com Inc.
 * Copyright (c) 2021 All Rights Reserved.
 */
package com.wk.leetcode.SwordOffer;

import com.wk.leetcode.common.TreeNode;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2021-02-12 17:11
 */
public class SwordOffer07 {

    private int[] preorder;

    private HashMap<Integer, Integer> inorderIndex = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int index = 0;
        for (int val : inorder) {
            inorderIndex.put(val, index++);
        }
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * root是前序遍历的下标，left，right是中序遍历中左右子树的范围
     * @param root
     * @param left
     * @param right
     * @return
     */
    public TreeNode recur(int root, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        // 中序遍历数组中的root节点的下标
        int i = inorderIndex.get(preorder[root]);
        node.left = recur(root + 1, left, i - 1);
        // 中序遍历中右子节点为root + 左子树长度 + 1
        node.right = recur(root + i - left + 1, i + 1, right);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode tree = new SwordOffer07().buildTree(preorder, inorder);
        tree.preOrderShow();
        System.exit(0);
    }

}
