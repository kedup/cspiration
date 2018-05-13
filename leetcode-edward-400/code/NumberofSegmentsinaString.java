package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : NumberofSegmentsinaString
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 434. Number of Segments in a String
 */
public class NumberofSegmentsinaString {
    /**
     * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

     Please note that the string does not contain any non-printable characters.

     Example:

     Input: "Hello, my name is John"
     Output: 5

     time : O(n)
     space : O(1)

     * @param s
     * @return
     */
    public int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        return s.split("\\s+").length;
    }
}
