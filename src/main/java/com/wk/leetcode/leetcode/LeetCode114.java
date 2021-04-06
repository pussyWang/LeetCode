package com.wk.leetcode.leetcode;

import com.wk.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class LeetCode114 {
    public void flatten(TreeNode root) {
        if (root != null) {
            Deque<TreeNode> deque = new LinkedList<>();
            treePutQueue(root, deque);
            if (!deque.isEmpty()) {
                root = deque.pollFirst();
                TreeNode tmp = root;
                tmp.left = null;
                while (!deque.isEmpty()) {
                    tmp.right = deque.pollFirst();
                    tmp.left = null;
                    tmp = tmp.right;
                }
            }
        }
    }

    public void treePutQueue(TreeNode root, Deque<TreeNode> deque) {
        if (root != null) {
            deque.offer(root);
            treePutQueue(root.left, deque);
            treePutQueue(root.right, deque);
        }
    }

}
