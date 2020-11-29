/**
 * wk.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.wk.leetcode.ChengxuyuanJindian;

/**
 * https://leetcode-cn.com/problems/one-away-lcci/
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2020-11-29 15:50
 */
public class CXYJD0105 {

    public boolean oneEditAway(String first, String second) {
        if (first == null && second == null) return true;
        if (first == null || second == null ) return false;
        int lenAbs = Math.abs(first.length() - second.length());
        if (lenAbs >= 2) {
            return false;
        }
        return false;

    }
}
