package com.wk.leetcode.leetcode;

import javax.crypto.spec.PSource;

/**
 * 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class LeetCode125 {
    public static boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        boolean r = true;
        int i=0, j=s.length()-1;
        String _s = s.toLowerCase();
        while(i < j) {
            char ci = _s.charAt(i);
            if ( !((ci >= 'a' && ci <= 'z') || (ci >= '0' && ci <= '9'))) {
                i++;
                continue;
            }
            char cj = _s.charAt(j);
            if (!((cj >= 'a' && cj <= 'z')|| ( cj >= '0' && cj <= '9'))) {
                j--;
                continue;
            }
            if (ci != cj) {
                r=false;
                break;
            }
            i++;
            j--;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("asdsa"));
        System.exit(0);
    }
}
