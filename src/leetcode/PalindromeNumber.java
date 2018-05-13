package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PalindromeNumber
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class PalindromeNumber {

    /**
     * 9. Palindrome Number

     time : O(n) space : O(1)
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) return false;
        int palind = x;
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return palind == rev;
    }
}
