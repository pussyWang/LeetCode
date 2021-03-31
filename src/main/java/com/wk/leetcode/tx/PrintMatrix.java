package com.wk.leetcode.tx;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺序输出螺旋矩阵
 * 给定一个包含m x n个元素的矩阵(m行, n列)，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *     输入:
 *         [
 *          [ 1, 2, 3 ],
 *          [ 4, 5, 6 ],
 *          [ 7, 8, 9 ]
 *         ]
 *     输出: [1,2,3,6,9,8,7,4,5]
 */
public class PrintMatrix {

    private static List<Integer> showMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int row = matrix.length, col = matrix[0].length;
        List<Integer> result = new ArrayList<>(row * col);
        int startCol = 0, endCol = col - 1;

        int startRow = 0, endRow = row - 1;
        while (startCol <= endCol && startRow <= endRow) {
            if (startCol <= endCol && startRow <= endRow) {
                for (int i = startCol; i <= endCol; i++) {
                    result.add(matrix[startRow][i]);
                }
                ++startRow;
            }
            if (startCol <= endCol && startRow <= endRow) {
                for (int i = startRow; i <= endRow; i++) {
                    result.add(matrix[i][endCol]);
                }
                --endCol;
            }
            if (startCol <= endCol && startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    result.add(matrix[endRow][i]);
                }
                --endRow;
            }
            if (startCol <= endCol && startRow <= endRow) {
                for (int i = endRow; i >= startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
                ++startCol;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> r = showMatrix(matrix);
        for (Integer i : r) {
            System.out.print(i + " ");
        }
        System.exit(0);
    }

}
