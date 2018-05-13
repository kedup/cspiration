package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RemoveInvalidParentheses
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 301. Remove Invalid Parentheses
 */
public class RemoveInvalidParentheses {
    /**
     * Remove the minimum number of invalid parentheses in order to make the input string valid.
     * Return all possible results.

     Note: The input string may contain letters other than the parentheses ( and ).

     Examples:
     "()())()" -> ["()()()", "(())()"]
     "(a)())()" -> ["(a)()()", "(a())()"]
     ")(" -> [""]
     Credits:
     Special thanks to @hpplayer for adding this problem and creating all test cases.

     time : 不知道
     space : O(n)



     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }
    public void helper(List<String> res, String s, int last_i, int last_j, char[] pair) {
        for (int count = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) count++;
            if (s.charAt(i) == pair[1]) count--;
            if (count >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1])) {
                    helper(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            helper(res, reversed, 0, 0, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }
}
