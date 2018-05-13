package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : GuessNumberHigherorLower
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class GuessNumberHigherorLower {
    /**
     * 374. Guess Number Higher or Lower
     *
     * We are playing the Guess Game. The game is as follows:

     I pick a number from 1 to n. You have to guess which number I picked.

     Every time you guess wrong, I'll tell you whether the number is higher or lower.

     You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

     -1 : My number is lower
     1 : My number is higher
     0 : Congrats! You got it!


     * time : O(logn);
     * space : O(1);
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (guess((mid)) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (guess(start) == 0) return start;
        return end;
    }


    // 防止编译器报错函数
    public int guess(int num) {
        return 0;
    }
}
