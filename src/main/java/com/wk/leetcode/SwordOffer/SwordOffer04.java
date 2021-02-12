/**
 * Baidu.com Inc.
 * Copyright (c) 2021 All Rights Reserved.
 */
package com.wk.leetcode.SwordOffer;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2021-02-11 13:20
 */
public class SwordOffer04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = 0, rowSize = matrix[0].length;
        if (matrix[0][0] > target) {
            return false;
        }
        while (matrix[0][rowSize - 1] < target) {
            row++;
        }
        int curRow = row + 1, colunm = 0;
        while (colunm < rowSize) {
            if (matrix[curRow][colunm++] == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean findNumberIn2Arr(int[][] matix , int target)  {
        if (matix == null || matix.length == 0 || matix[0].length == 0) {
            return false;
        }

        int rows = matix.length, columns = matix[0].length;
        int row=0, column = columns - 1;
        while (row  < rows && column  >= 0) {
            int num = matix[row][column];
            if (num == target) {
                return true;
            } else if (num < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        System.out.println(findNumberIn2Arr(matix, 15));
        System.exit(0);
    }
}
