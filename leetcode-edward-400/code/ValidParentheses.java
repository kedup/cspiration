package leetcode;

import java.util.Stack;

/**
 * Created by Edward on 27/07/2017.
 */
public class ValidParentheses {
    /**
     * 20. Valid Parentheses
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

     case1 : ()[]{}
     stack :

     case2 : ([)]
     stack :

     case3 : }
     stack :

     time : O(n);
     space : O(n);
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
