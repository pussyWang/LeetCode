/**
 * Baidu.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.wk.leetcode.SwordOffer;

/**
 * 剑指offer 84
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2020-11-29 14:15
 */
public class SwordOffer84 {
    /**
     * 解法一：暴力枚举，每个位置上的最大矩形为向左小于自己高度的位置，向右小于自己高度的位置
     * 即 s[i] = height[i] * (right_height_gt_self_index - left_height_gt_self_index)
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
            // 向右找小于自己高度的柱子
            while (right < heights.length && heights[right] >= heights[i]) right++;
            int s = heights[i] * (right - left - 1);
            if (s > max) {
                max = s;
            }
        }
        return max;
    }
}
