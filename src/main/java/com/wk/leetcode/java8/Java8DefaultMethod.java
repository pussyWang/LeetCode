package com.wk.leetcode.java8;

public class Java8DefaultMethod {
    public static void main(String[] args) {
        MsgPrinter msgPrinter = new MsgPrinter() {
            @Override
            public String getMsg() {
                return "hello world";
            }
        };

        msgPrinter.printMsg();
    }

    interface MsgPrinter {
        String getMsg();

        /**
         * 扩展方法.
         * 用default来定义, 有实现体.
         * (本来接口是不允许有实现了的方法的)
         */
        public default void printMsg() {
            String str = getMsg();
            System.out.println(str);
        }
    }
}
