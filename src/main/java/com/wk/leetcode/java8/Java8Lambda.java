package com.wk.leetcode.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Lambda {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 2, 5, 4);
        List<Integer> list2 = Arrays.asList(1, 3, 2, 5, 4);

        /*
         * 新的Lambda写法, 代码更加简洁. (对比下面的原来的写法)
         */
        Collections.sort(list1, (o1, o2) -> o1 - o2);
        /*
         * 原来的写法.
         */
        Collections.sort(list2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println(list1);
        System.out.println(list2);
    }
}
