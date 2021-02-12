/**
 * Baidu.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.wk.leetcode.sort;

/**
 * 快排 递归实现
 * 核心思想是：每次拿一个基准数，一次遍历找到该数据的位置，保证在这个数的左边的数都小于基准，右边的都大于基准
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2020-12-25 10:38
 */
public class QuickSort {

    private static void qSort(int[] arr, int left, int right) {
        if (left > right ) return;
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            arr[i] = arr[j];
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        qSort(arr, left, i - 1);
        qSort(arr, i+1, right);
    }

    public static void main(String[] args) {
        int[] arr = {3,0,9,1,2,3,2,6};
        qSort(arr,0, arr.length - 1);
        for (int i : arr) {
            System.out.printf(i + " ");
        }
        System.exit(0 );
    }
}
