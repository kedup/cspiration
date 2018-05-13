package leetcode;

import java.util.Stack;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LongestAbsoluteFilePath
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 388. Longest Absolute File Path
 */
public class LongestAbsoluteFilePath {
    /**
     * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
     * dir
        subdir1
        subdir2
            file.ext
     dir\ subdir2\ file.ext
      3     7         8    =  20

     dir \tsubdir1 \tsubdir2 \t\tfile.ext


     stack : 0 4 12 21
     dir : level = 0
     \tsubdir1 \tsubdir2 : level = 1
     \t\tfile.ext ; level = 2

     time : O(n)
     space : O(n)


     * @param input
     * @return
     */
    public static int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }

}
