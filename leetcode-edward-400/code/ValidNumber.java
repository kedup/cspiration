package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ValidNumber
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ValidNumber {

    /**
     * 65. Valid Number
     * Validate if a given string is numeric.

     Some examples:
     "0" => true
     " 0.1 " => true
     "abc" => false
     "1 a" => false
     "2e10" => true

     time : O(n);
     space : O(1);
     * @param s
     * @return
     */

    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterE = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
}
