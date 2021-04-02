/**
 * Baidu.com Inc.
 * Copyright (c) 2021 All Rights Reserved.
 */
package com.wk.leetcode.dynamic;

/**
 * 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2021-04-02 15:40
 */
public class Dynamic300 {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i=1; i< nums.length;i++ ) {
            dp[i] = 1;
            for (int j=0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
        System.exit(0);
    }
}
