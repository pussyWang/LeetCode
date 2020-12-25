/**
 * Baidu.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.wk.leetcode.sort;

/**
 *
 * 合并排序，递归
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2020-12-25 10:08
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,23,4,6,7,9,10};
        sort(arr);
        for (int i : arr) {
            System.out.printf(i + " ");
        }
        System.exit(0);
    }

    private static void sort(int[] arr) {
        if (arr != null && arr.length > 0) {
            mSort(arr, 0, arr.length - 1);
        }
    }

    private static void mSort(int[] arr, int left, int right) {
        if (left < right){
            int mid = (left + right) / 2;
            mSort(arr, left, mid);
            mSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] arr2 = new int[right - left + 1];
        // 开始合并两个子数组
        int i=left,j=mid + 1,k=0;
        while (i <= mid && j <= right) {// 注意边界值 下标要走mid 和 right的位置
            if (arr[i] > arr[j]) {
                arr2[k++] = arr[i++];
            } else {
                arr2[k++] = arr[j++];
            }
        }
        while (j <= right) {
            arr2[k++] = arr[j++];
        }

        while (i <= mid) {
            arr2[k++] = arr[i++];
        }
        i=left;
        k=0;
        while (k < arr2.length) {
            arr[i++] = arr2[k++];
        }
    }
}
