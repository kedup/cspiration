package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : GrayCode
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 89. Gray Code
 */
public class GrayCode {
    /**
     * The gray code is a binary numeral system where two successive values differ in only one bit.

     Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
     A gray code sequence must begin with 0.

     For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

     00 - 0
     01 - 1
     11 - 3
     10 - 2

     G(i) = i ^ (i/2)

     time : O(1 << n) / O(n)
     space : O(1 << n) / O(n)

     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }
}
