package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : NimGame
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 292. Nim Game
 */
public class NimGame {
    /**
     * You are playing the following Nim Game with your friend: There is a heap of stones on the table,
     * each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner.
     * You will take the first turn to remove the stones.

     Both of you are very clever and have optimal strategies for the game. Write a function to determine
     whether you can win the game given the number of stones in the heap.

     1-true
     2-true
     3-true
     4-false
     5-true
     6-true
     7-true
     8-false

     time : O(1)
     space : O(1)

     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
