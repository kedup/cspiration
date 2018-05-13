package leetcode;

import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LongestValidParentheses
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 32. Longest Valid Parentheses
 */
public class LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.

     For "(()", the longest valid parentheses substring is "()", which has length = 2.

     Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

     0 1 2 3 4 5
     ( ( ) )

     time : O(n)
     space : O(n)


     * @param s
     * @return
     */

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
}
