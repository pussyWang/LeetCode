/**
 * Baidu.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.wk.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2020-03-15 14:08
 */
public class Double2Int {

    public static void main(String[] params) {
        System.out.println(getMaxSubStr("1234567890abcd9.+12345.678.9ed"));
        System.exit(0);
    }

    private static String getMaxSubStr(String s) {
        List<Character> number = new ArrayList<>();
        number.add('0');
        number.add('1');
        number.add('2');
        number.add('3');
        number.add('4');
        number.add('5');
        number.add('6');
        number.add('7');
        number.add('8');
        number.add('9');
        List<Character> sign = new ArrayList<>();
        sign.add('+');
        sign.add('-');
        char[] chars = s.toCharArray();
        StringBuilder dst = new StringBuilder();
        int p = 0;
        boolean hasPoint = false;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (p == 0 && (number.contains(c) || sign.contains(c))) {
                p++;
                dst.append(chars[i]);
            } else if (p > 0 && number.contains(c)) {
                p++;
                dst.append(chars[i]);
            } else if (!hasPoint && c == '.' && number.contains(chars[i + 1])) {
                p++;
                dst.append(chars[i]);
                hasPoint = true;
            } else {
                if (p > 0) {
                    subs.add(dst.toString());
                }
                p = 0;
                hasPoint = false;
                dst = new StringBuilder();
            }
        }
        String max = "";
        if (!subs.isEmpty()) {
            for (String _s : subs) {
                max = max.length() <= _s.length() ? _s : max;
            }
        }
        return max;
    }
}
