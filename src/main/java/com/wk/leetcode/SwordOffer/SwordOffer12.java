/**
 * Baidu.com Inc.
 * Copyright (c) 2021 All Rights Reserved.
 */
package com.wk.leetcode.SwordOffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）
 * 思路：dfs深度优先遍历
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2021-02-12 17:45
 */
public class SwordOffer12 {
    public static Deque<Integer> target = new LinkedList<Integer>();
    int columnSize = 0;
    int rowSize = 0;

    public boolean exist(char[][] board, String word) {
        this.columnSize = board[0].length;
        this.rowSize = board.length;
        char[] _word = word.toCharArray();
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[i].length; j++) {
//                if (perExist(board, _word, 0 , i, j)) {
//                    return true;
//                }
                if (dfs(board, _word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }


    public boolean perExist(char[][] board, char[] w, int index, int row, int column) {
        int t = row * rowSize + column;
        if (target.contains(t)) {
            return false;
        }
        target.add(t);
        if (board[row][column] != w[index]) {
            return false;
        }
        if (index == w.length - 1) {
            return true;
        }
        boolean r = false;
        if (row - 1 >= 0) {
            r = r || perExist(board, w, index + 1,row - 1, column);
        }
        if (row + 1 < rowSize) {
            r = r || perExist(board, w, index + 1, row + 1, column);
        }
        if (column - 1 >= 0) {
            r = r || perExist(board, w, index + 1, row, column - 1);
        }
        if (column + 1 < columnSize){
            r = r || perExist(board, w, index + 1, row, column + 1);
        }
        target.poll();
        return r;
    }

    public static void main(String[] args) {
//        char[][] board = {{'a', 'b', 'c', 'e'},{'s','f','c','s'},{'a','d', 'e', 'e'}};
////        String word = "bfce";
//        char[][] board = {{'A','B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
//        char[][] board = {{'a','b'}, {'c', 'd'}};
////        String word = "acdb";
//        char[][] board = {
//                {'C','A', 'A'},
//                {'A', 'A', 'A'},
//                {'B', 'C', 'D'}};
//        String word = "AAB";
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";
        System.out.println(new SwordOffer12().exist(board, word));
        System.exit(0);
    }
}
