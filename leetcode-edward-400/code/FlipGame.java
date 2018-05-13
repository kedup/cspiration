package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FlipGame
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 293. Flip Game
 */
public class FlipGame {
    /**
     * For example, given s = "++++", after one move, it may become one of the following states:

     [
     "--++",
     "+--+",
     "++--"
     ]
     If there is no valid move, return an empty list [].

     time : O(n)
     space : O(n);


     * @param s
     * @return
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return res;
    }
}
