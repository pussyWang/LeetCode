package com.wk.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 华为机试
 * 100个人围成一圈，从1开始报数，报到M的人出局，输出剩下的M-1个人的编号
 * 牛客网根据输出的结果判断用例是否通过，提交后不可修改，淦
 */
public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int num = input.nextInt();
            if (num <=0 || num >= 100) {
                System.out.println("params error!");
                break;
            }
            List<Integer> r = move(num);
            StringBuffer sb = new StringBuffer();
            for (int i=0; i<r.size();i++) {
                sb.append(r.get(i));
                if (i+1 != r.size()) {
                    sb.append(",");
                }
            }
            System.out.println(sb.toString());
        }
        System.exit(0);
    }

    public static List<Integer> move(int num) {
        List<Integer> nums = new ArrayList<>();
        for (int i=1;i<=100;i++) {
            nums.add(i);
        }

        int i=1;
        while (nums.size() >= num) {
            List<Integer> tmp = new ArrayList<>();
            for (int j=0;j<nums.size();j++) {
                if (i != num) {
                    tmp.add(nums.get(j));
                    i++;
                } else {
                    i = 1;
                }
            }
            nums = tmp;
        }
        return nums;
    }

}
