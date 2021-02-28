package com.wk.leetcode.java8;

public class Java8MethodReferences {
    public static void main(String[] args) {

        /**
         * 可以通过函数式接口来引用方法.
         * 引用符号 ::
         *
         * 有几种引用方法.
         * 具体请参考以下链接
         * <a href='http://blog.csdn.net/kimylrong/article/details/47255123'>Java 8之方法引用(Method References)</a>
         * <a href='http://blog.csdn.net/wwwsssaaaddd/article/details/37573517'>java8 - 方法引用(method referrance)</a>
         *
         * 1. 引用静态方法 ContainingClass::staticMethodName
         * 2. 引用特定对象的实例方法 containingObject::instanceMethodName
         * 3. 引用特定类型的任意对象的实例方法  ContainingType::methodName
         * 4. 引用构造函数 ClassName::new
         */
        TwoVarFunctionalInterface1 f = Java8MethodReferences::staticAddMethod;

        System.out.println(f.foo(2,3));

    }

    private static int staticAddMethod(int a, int b) {
        return a + b;
    }
}

/**
 * 二元接口.
 * 用FunctionalInterface标识函数式接口.
 * 函数式接口只能有一个方法.
 */
@FunctionalInterface
interface TwoVarFunctionalInterface1 {
    int foo(int m, int n);
}
