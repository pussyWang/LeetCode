package com.wk.leetcode.java8;

public class Java8FunctionalInterface {
    public static void main(String[] args) {
        /**
         * 使用Lambda简写.
         */
        Java8FunctionalInterface.printSum((m, n) -> m + n, 2, 3);
        Java8FunctionalInterface.printSum((m, n) -> m - n, 2, 3);
        Java8FunctionalInterface.printSum((m, n) -> m * n, 2, 3);
        Java8FunctionalInterface.printSum((m, n) -> m / n, 2, 3);
    }

    /**
     * 方法接受一个函数式接口对象,使用场景方法回调
     * @param f 函数
     * @param m 参数1
     * @param n 参数2
     */
    private static void printSum(TwoVarFunctionalInterface f, int m, int n) {
        System.out.println(f.foo(m,n));
    }
}

@FunctionalInterface
interface TwoVarFunctionalInterface {
    int foo(int m, int n);
}