package com.wk.leetcode.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 华为机试
 * 求最大利润
 * 输入两个数组m,n, m为商品成本，n为商品售价，每件商品只能买卖一次
 * 本金 money
 * 求最大的利润
 *
 * 解法一： 网上查到的，按每件商品的利润排序
 */
public class MaxProfit {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mline = br.readLine().split(",");
        String[] nline = br.readLine().split(",");
        String moneyStr = br.readLine();
        int[] m = str2int(mline);
        int[] n = str2int(nline);
        int money = Integer.parseInt(moneyStr);
        int k = fin(m, n, money);
        System.out.println(k);
    }

    static int[] str2int(String[] m) {
        int[] r = new int[m.length];
        for (int i=0;i<m.length;i++) {
            r[i] = Integer.parseInt(m[i]);
        }
        return r;
    }

    static int fin(int[] m, int[] n ,int money) {
        List<Good> goods = new ArrayList<>();
        for (int i=0; i < m.length;i++) {
            Good good = new Good();
            good.bg = m[i];
            good.tr = n[i] - m[i];
            good.visit = 0;
            goods.add(good);
        }
        Collections.sort(goods, new Comparator<Good>() {
            @Override
            public int compare(Good o1, Good o2) {
                return o2.tr - o1.tr;
            }
        });
        int f = money;
        while (checkVec(goods, f)) {
            for (int i=0;i < goods.size(); i++) {
                if (f < goods.get(i).bg) {
                    continue;
                }
                if (goods.get(i).tr <= 0) {
                    continue;
                }
                if (goods.get(i).visit == 1) {
                    continue;
                }
                f = f + goods.get(i).tr;
                goods.get(i).visit = 1;
            }
        }

        return f;
    }


    static boolean checkVec(List<Good> goods, int k) {
        boolean flag = false;
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).visit == 1) {
                continue;
            }
            if (goods.get(i).tr <= 0) {
                continue;
            }
            if (k > goods.get(i).bg) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    static class Good {
        public int bg; // 成本
        public int tr; // 利润
        public int visit = 0; // 是否访问过
    }
}
