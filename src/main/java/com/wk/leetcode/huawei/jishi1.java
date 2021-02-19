package com.wk.leetcode.huawei;

import com.sun.tools.javac.util.StringUtils;

public class jishi1 {

    public static void main(String[] args) {
        if(args != null && args.length > 0) {
            for (String i : args) {
                if(i != null && i.length() > 0) {
                    int start = 0;
                    int end = 8;
                    while(i.length() > end) {
                        //re.add(new String(input.subStr(start, end)));
                        System.out.println(i.substring(start, end));
                        start = end;
                        end += 8;
                    }
                    String r = new String(i.substring(start));
                    while(r.length() < 8) {
                        r += '0';
                    }
                    System.out.println(r);
                }
            }
        }
    }
}
