/**
 * Baidu.com Inc.
 * Copyright (c) 2021 All Rights Reserved.
 */
package com.wk.leetcode.leetcode;

import java.util.Arrays;

/**
 * 最大矩形
 * https://leetcode-cn.com/problems/maximal-rectangle/
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2021-04-02 14:51
 */
public class LeetCode85 {

    /**
     * 求柱形图最大面积
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
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

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int rowCnt = matrix.length;
        int colCnt = matrix[0].length;

        int[] rowHeights = new int[colCnt];
        Arrays.fill(rowHeights, 0);
        int maxCnt = 0;
        for (int i=0; i < rowCnt;i++) {
            for (int j=0;j < colCnt; j++) {
                if (matrix[i][j] == '0') {
                    rowHeights[j] = 0;
                } else {
                    rowHeights[j] += 1;
                }
            }
            int curCnt = largestRectangleArea(rowHeights);
            maxCnt = Math.max(curCnt, maxCnt);
        }

        return maxCnt;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
                {'1','0','1','0','0'}
        };
        System.out.println(maximalRectangle(matrix));
        System.exit(0);
    }
}
