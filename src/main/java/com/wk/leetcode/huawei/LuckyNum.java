package com.wk.leetcode.huawei;


import java.util.ArrayList;
import java.util.List;

/**
 * Chenwenzheng c00556535对所有人说 (7:30 下午)
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 *
 * 示例 1：
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 *
 * 示例 2：
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 *
 * 示例 3：
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 */
public class LuckyNum {

    private static List<Integer>  findLuckyNum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int rowCnt = matrix.length;
        int colCnt = matrix[0].length;
        for (int i=0;i < rowCnt ;i++) {
            int mayBeLucyNum = matrix[i][0];
            int mayBeLuckyNumCol = 0;
            // 校验是否是行最小
            for (int j=1;j< colCnt;j++) {
                if (mayBeLucyNum > matrix[i][j]) {
                    mayBeLucyNum = matrix[i][j];
                    mayBeLuckyNumCol = j;
                }
            }
            // 校验是否是列中最大的元素
            for (int k=0; k < rowCnt;k++) {
                if (mayBeLucyNum < matrix[k][mayBeLuckyNumCol]) {
                    mayBeLucyNum = -1;
                    break;
                }
            }
            if (mayBeLucyNum != -1) {
                result.add(mayBeLucyNum);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        List<Integer> luckyNums = findLuckyNum(matrix);
        for (int num : luckyNums) {
            System.out.print(num + " ");
        }
        System.exit(0);
    }



}
