package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : VerifyPreorderSerializationofaBinaryTree
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 331. Verify Preorder Serialization of a Binary Tree
 */
public class VerifyPreorderSerializationofaBinaryTree {
    /**
     * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

          _9_
         /   \
        3     2
       / \   / \
      4   1  #  6
     / \ / \   / \
     # # # #   # #

     For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

     Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

     Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

     You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

     Example 1:
     "9,3,4,#,#,1,#,#,2,#,6,#,#"
     Return true

     Example 2:
     "1,#"
     Return false

     Example 3:
     "9,#,#,1"
     Return false

     all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
     all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).

     diff = outdegree - indegree

     time : O(n)
     space : O(n)

     * @param preorder
     * @return
     */

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}
