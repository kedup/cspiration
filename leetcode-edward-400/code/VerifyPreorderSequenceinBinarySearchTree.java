package leetcode;

import java.util.Iterator;
import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : VerifyPreorderSequenceinBinarySearchTree
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 255. Verify Preorder Sequence in Binary Search Tree
 */
public class VerifyPreorderSequenceinBinarySearchTree {
    /**
     *    6
         / \
        1  8
      /  \
     0   3
        / \
       2  5

     preorder : 6 1 0 3 2 5 8

     num : 8
     min : 6
     stack : 8

     time : O(n)
     space : O(n)

     * @param preorder
     * @return
     */

    public static boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}
