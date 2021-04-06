package com.wk.leetcode.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 * 思路：以所有在边界上的o为起点追溯所有在内部的相连的o并置为x
 * 第一步：遍历分别 保存所有o的坐标以及所有不被包围的o的坐标
 * 第二步：遍历所有o的坐标并将包围的o的置为x
 */
public class LeetCode130 {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rowCnt = board.length;
        int colCnt = board[0].length;
        Set<Integer> allOIndex = new HashSet<>();
        Set<Integer> noBoardOIndex = new HashSet<>();
        for (int i=0;i<rowCnt;i++) {
            for (int j=0;j<colCnt;j++) {
                if (board[i][j] == 'O') {
                    allOIndex.add(i*colCnt + j);
                    if (i == 0 || i == (rowCnt -1) || j == 0 || j== (colCnt-1)) {
                        markNoBoard(board, i, j, noBoardOIndex);
                    }
                }
            }
        }
        for (Integer index : allOIndex) {
            if (!noBoardOIndex.contains(index)) {
                int row = index / colCnt;
                int col = index % colCnt;
                board[row][col] = 'X';
            }
        }
    }

    public static void markNoBoard(char[][] board, int i, int j, Set<Integer> noBoardOIndex) {
        int rowCnt = board.length;
        int colCnt = board[0].length;
        if (i < 0 || i >= rowCnt || j < 0 || j >= colCnt) {
            return;
        }
        int index = i * colCnt + j;
        if(board[i][j] == 'O' && !noBoardOIndex.contains(index)) {
            noBoardOIndex.add(index);
            markNoBoard(board, i-1, j, noBoardOIndex);
            markNoBoard(board, i+1, j, noBoardOIndex);
            markNoBoard(board, i, j-1, noBoardOIndex);
            markNoBoard(board, i, j+1, noBoardOIndex);
        }
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'X','X','X','X'},
//                {'X','O','O','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'},
//        };
//        char[][] board = {{'O','O'},{'O','O'}};
        char[][] board = {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };
        solve(board);
        int rowCnt = board.length;
        int colCnt = board[0].length;
        for (int i=0;i<rowCnt;i++) {
            for (int j=0;j<colCnt;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.exit(0);
    }
}
