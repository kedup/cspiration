package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindtheCelebrity
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 277. Find the Celebrity
 */
public class FindtheCelebrity {
    /**
     * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
     * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
     * You are given a helper function bool knows(a, b) which tells you whether A knows B.
     * Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
     *
     * 0 1 2 3 4 5
     *   3 : Celebrity
     *   0 : 1   1: 2   2 : 4   4 : 5   5 : 1
     *   possible = 3
     *
     * time : O(n)
     * space : O(1)
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        if (n < 2) return -1;
        int possible = 0;
        for (int i = 1; i < n; i++) {
            if (knows(possible, i)) {
                possible = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (possible != i && ((knows(possible, i) || !knows(i, possible)))) {
                return -1;
            }
        }
        return possible;
    }

    public boolean knows(int a, int b) {
        return true;
    }
}
