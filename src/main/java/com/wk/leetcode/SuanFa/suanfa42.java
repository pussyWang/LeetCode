package com.wk.leetcode.SuanFa;


/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class suanfa42 {

    // 遍历计算每根柱子上可以蓄的水，时间复杂度 O(n2)
    public static int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int total = 0;
        for(int i=0; i<height.length;i++){
            total += perTrap(height, i);
        }
        return total;
    }
    private static int perTrap(int[] height, int cur) {
        if(cur == 0 || cur == height.length - 1) return 0;
        int leftmax = height[cur],leftindex = cur-1;
        while(leftindex >= 0){
            if (height[leftindex] > leftmax)  {
                leftmax = height[leftindex];
            }
            leftindex--;
        }
        int rightmax = height[cur],righindex = cur + 1;
        while(righindex < height.length ){
            if ( height[righindex] > rightmax){
                rightmax = height[righindex];
            }
            righindex++;
        }
        int min = Math.min(leftmax, rightmax);
        return min - height[cur];
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int re = trap(arr);
        System.out.println("result=" + re);
        System.exit(0);
    }
}
