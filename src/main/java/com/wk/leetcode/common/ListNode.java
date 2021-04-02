/**
 * Baidu.com Inc.
 * Copyright (c) 2021 All Rights Reserved.
 */
package com.wk.leetcode.common;

/**
 * 单向列表
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2021-04-02 15:09
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int... vals) {
        ListNode header = null;
        for (int i=0;i < vals.length;i++) {

        }
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
