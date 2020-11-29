/**
 * wk.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.wk.leetcode.SwordOffer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2020-11-29 15:11
 */
public class SwordOffer03 {
    /**
     * wrong method
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        if (nums == null) return 0;
        int r = nums[0];
        for (int i=1; i < nums.length;i++) {
            r ^= nums[i];
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
        System.exit(0);
    }


}
