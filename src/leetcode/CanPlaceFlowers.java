package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CanPlaceFlowers
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class CanPlaceFlowers {
    /**
     * 605. Can Place Flowers
     * Suppose you have a long flowerbed in which some of the plots are planted
     * and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

     Given a flowerbed (represented as an array containing 0 and 1, where
     0 means empty and 1 means not empty), and a number n, return if n new flowers can be
     planted in it without violating the no-adjacent-flowers rule.

     Input: flowerbed = [1,0,0,0,1], n = 1
     Output: True
     Input: flowerbed = [1,0,0,0,1], n = 2
     Output: False

     time : O(n);
     space : O(1);
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 || flowerbed[i - 1] == 0) {
                    if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                }
            }
        }
        return count >= n;
    }
}
