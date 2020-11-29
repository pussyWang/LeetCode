/**
 * Baidu.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.wk.leetcode.ChengxuyuanJindian;

/**
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 *
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2020-11-29 15:29
 */
public class CXYJD0103 {
    public static String replaceSpaces(String s, int length) {
        char[] _s = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i < length; i++){
            if (_s[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(_s[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        int length = 13;
        System.out.println(replaceSpaces(s, length));
        System.exit(0);
    }
}
