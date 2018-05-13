package leetcode;

import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : Candy
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 135. Candy
 */
public class Candy {
    /**
     * There are N children standing in a line. Each child is assigned a rating value.

     You are giving candies to these children subjected to the following requirements:

     Each child must have at least one candy.
     Children with a higher rating get more candies than their neighbors.
     What is the minimum candies you must give?

     ratings:     [4, 5, 1, 1, 3, 7]
     candies:     [1, 1, 1, 1, 1, 1]

     ratings:     [4, 5, 1, 1, 3, 7]
     candies:     [1, 2, 1, 1, 2, 3]

     ratings:     [4, 5, 1, 1, 3, 7]
     candies:     [1, 2, 1, 1, 2, 3]

     time : O(n)
     space : O(n)


     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = candies.length - 2; i >= 0; i --) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int res = 0;
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }
}
