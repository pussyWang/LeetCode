/**
 * Baidu.com Inc.
 * Copyright (c) 2021 All Rights Reserved.
 */
package com.wk.leetcode.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2021-04-02 10:11
 */
public class LeetCode32 {

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                } else {
                    dp[i] = 0;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static int longestValidParentheses2(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // 栈元素存储的是当前下标之前所有能组成有效子串的起始下标
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses2(s));
        System.exit(0);
    }
}
