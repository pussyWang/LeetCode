/**
 * Baidu.com Inc.
 * Copyright (c) 2021 All Rights Reserved.
 */
package com.wk.leetcode.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 柱状图中最大距形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2021-04-02 11:39
 */
public class LeetCode84 {
    /**
     * 类似于接雨水
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null) return 0;
        int max = 0;
        for (int i=0; i < heights.length; i++) {
            // 向左找小于自己高度的柱子
            int left = i-1;
            while (left > -1 && heights[left] >= heights[i]) left--;
            int right = i+1;
            while (right < heights.length && heights[right] >= heights[i]) right++;
            int s = heights[i] * (right - left - 1);
            if (s > max) {
                max = s;
            }
        }
        return max;
    }

    /**
     * 单调栈实现
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
