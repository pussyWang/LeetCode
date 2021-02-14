/**
 * Baidu.com Inc.
 * Copyright (c) 2021 All Rights Reserved.
 */
package com.wk.leetcode.common;

/**
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2021-02-12 17:12
 */
public class TreeNode {
    public Integer val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void preOrderShow() {
        show(this);
    }

    private void show(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val  + " ");
        show(root.left);
        show(root.right);
    }
}
