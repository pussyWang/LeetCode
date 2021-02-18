/**
 * Baidu.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.wk.leetcode.huawei;


import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @author wangkang06
 * @version 1.0
 * @description
 * @date 2020-03-18 23:49
 */
public class StringContact {

    /**
     * 字符串接龙
     */

   private static int maxContactLength(List<String> strings) {
       // 第一步进行清理，如果存在一个单词首字母和尾字母都不能和其他的单词相连，
       // 认为这个单词是孤立的，从列表清除出去，保证列表内的的单词收尾是有关联性的
       int count = 0;
       for (String s : strings) {
           List<String> tmp = Lists.newArrayList(strings);
           tmp.remove(s);
           // 当前单词能构造的最长接龙
           int c = leftMaxDeep(tmp, s);
           count = Math.max(count, c);
       }

       return count;
   }

   //根据单词的尾字符去剩余的单词里寻找最长的接龙
    private static int leftMaxDeep(List<String> strs, String s) {
        int deep = 0;
        // 没有可用的单词，长度为0
        if (CollectionUtils.isEmpty(strs)) {
            return deep;
        }
        char tail = s.toCharArray()[s.length() - 1];
        boolean isExist = false;
        for (String _s : strs) {
            // 首尾相等
            if (tail == _s.toCharArray()[0]) {
                List<String> tmp = Lists.newArrayList(strs);
                tmp.remove(_s);
                int childDeep = leftMaxDeep(tmp, _s);
                deep = Math.max(deep, childDeep);
                isExist = true;
            }
        }


        // 不存在匹配的单词，结果返回0；如果存在，在子链长度上加1
        return isExist ? deep + 1 : 0;
    }

    public static void main(String[] args) {
        List<String> s  = Lists.newArrayList("adf","fdw","asdc","cb","bd","df","wa");
        System.out.println(maxContactLength(s));
        System.exit(0);
    }
}
