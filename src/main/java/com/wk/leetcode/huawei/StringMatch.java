/**
 * Baidu.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.wk.leetcode.huawei;

/**
 * 简单正则匹配
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2020-03-16 23:14
 */
public class StringMatch {

    public static void main(String[] args) {
        System.out.println(match("aab","c*a*b"));
        System.out.println(match("mississippi","mis*isp*"));
    }

    public static boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str.toCharArray(), strIndex, pattern.toCharArray(), patternIndex);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {

        // 都到了尾部 这是认为字符串完成了匹配
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        // 字符串不匹配
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }

        // 下一个字符如果是*
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // 当前字符相同 或者 匹配字符串的当前字符是.
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                // 当前字符不匹配 pattern后移俩位
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        // 如果当前的字符相同或者匹配了. 继续往下走匹配校验子串是否匹配
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

}
