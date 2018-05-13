package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : EliminationGame
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 390. Elimination Game
 */
public class EliminationGame {
    /**
     * Example:

     Input:
     n = 8,
     1 2 3 4 5 6 7 8
       2   4   6   8 res = 2
       2       6     res = 2
               6     res = 6


     1 2 3 4 5 6 7
       2   4   6
           4

     Output:
     6

     time : O(logn)
     space : O(1)

     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int res = 1; // head
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                res = res + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return res;
    }
}
