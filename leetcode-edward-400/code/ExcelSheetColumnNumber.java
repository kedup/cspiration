package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ExcelSheetColumnNumber
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 171. Excel Sheet Column Number
 */
public class ExcelSheetColumnNumber {
    /**
     * For example:

     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28

     AB -> 28
     res = 1 * 26 + 2 = 28

     time : O(n)
     space : O(1)

     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
