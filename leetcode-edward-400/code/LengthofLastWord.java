package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LengthofLastWord
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 58. Length of Last Word
 */
public class LengthofLastWord {
    /**
     * For example,
     Given s = "Hello World",
     return 5.

     time : O(1)
     space : O(1)

     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
