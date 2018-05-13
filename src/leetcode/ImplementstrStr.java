package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ImplementstrStr
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ImplementstrStr {
    /**
     * 28. Implement strStr()

     time : O(n^2)
     space : O(1)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}
