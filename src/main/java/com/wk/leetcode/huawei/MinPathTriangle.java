package com.wk.leetcode.huawei;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * leetcode 120
 */
public class MinPathTriangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int row = triangle.size() - 1;
        List<Integer> last = triangle.get(row);
        for (int i=0; i < last.size();i++) {
            int cur = perMin(triangle, row, i);
            if (cur < min) {
                min = cur;
            }
        }
        return min;
    }

    public int perMin(List<List<Integer>> triangle, int row,int col) {
        if (row >= 0 && col >= 0 && col < triangle.get(row).size()) {
            int cur = triangle.get(row).get(col);
            if (row - 1 >= 0 && col - 1 >= 0 && col - 1 < triangle.get(row - 1).size()) {
                int next = triangle.get(row - 1).get(col - 1) < triangle.get(row - 1).get(col) ? col - 1 : col;
                int m = perMin(triangle,row - 1 , next);
                return cur + m;
            } else {
                return cur;
            }
//            int m = Math.min(perMin(triangle, row - 1,col - 1),
//                    perMin(triangle,row - 1, col))
        } else {
            return Integer.MAX_VALUE;
        }
    }


    public static void main(String[] args) {
//        List<List<Integer>> triangle = Lists.newArrayList(Lists.newArrayList(2),
//                Lists.newArrayList(3,4),
//                Lists.newArrayList(6, 5, 7),
//                Lists.newArrayList(4,1,8,3));
//        List<List<Integer>> triangle = Lists.newArrayList();
//        triangle.add(Lists.newArrayList(-10));
        List<List<Integer>> triangle = Lists.newArrayList(Lists.newArrayList(-1),
                Lists.newArrayList(3,2),
                Lists.newArrayList(-3,1,-1));
        int re = new MinPathTriangle().minimumTotal(triangle);
        System.out.println(re);
        System.exit(0);
    }


}
