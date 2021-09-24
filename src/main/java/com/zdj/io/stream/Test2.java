package com.zdj.io.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdj
 * @date 2021/09/14
 */
public class Test2 {

    private static final char delFlag = '!';

    public String removeParentheses(String s) {
        // write your code here.
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left.add(i);
            }
            if (chars[i] == ')') {
                right.add(i);
            }
        }
        int ls = left.size();
        int rs = right.size();
        int b = ls - rs;
        // 没有左括号 删除所右右括号
        if (ls == 0) {
            for (int i = 0; i < rs; i++) {
                s = replaceCharAt(s, right.get(i));
            }
        }
        // 没有右括号 删除所有左括号
        if (rs == 0) {
            for (int i = 0; i < ls; i++) {
                s = replaceCharAt(s, left.get(i));
            }
        }
        // 删除左括号
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                s = replaceCharAt(s, left.get(ls - (i + 1)));
            }
        }
        // 删除右括号
        if (b < 0) {
            for (int i = 0; i < Math.abs(b); i++) {
                s = replaceCharAt(s, right.get(rs - (i + 1)));
            }
        }
        // 左括号的索引大于有括号的索引 则删除两个括号
        for (int i = 0; i < rs - Math.abs(b); i++) {
            if (left.get(i) > right.get(i)) {
                replaceCharAt(s, left.get(i));
                replaceCharAt(s, right.get(i));
            }
        }
        return s.replace(delFlag + "", "");
    }

    public String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    public String replaceCharAt(String s, int pos) {
        char[] chars = s.toCharArray();
        chars[pos] = delFlag;
        return new String(chars);
    }
}
