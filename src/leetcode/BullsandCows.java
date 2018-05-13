package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BullsandCows
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 299. Bulls and Cows
 */
public class BullsandCows {
    /**
     * For example:

     Secret number:  "1807"
     Friend's guess: "7810"
     Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
     Write a function to return a hint according to the secret number and friend's guess,
     use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

     Secret number:  "1123"
     Friend's guess: "0111"
     In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".

     time : O(n)
     space : O(1)


     * @param secret
     * @param guess
     * @return
     */

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (count[secret.charAt(i) - '0']++ < 0) cows++;
                if (count[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
