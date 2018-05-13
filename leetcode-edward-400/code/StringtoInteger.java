package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : StringtoInteger
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 8. String to Integer (atoi)
 */
public class StringtoInteger {
    /**
     * time : O(n)
     * space : O(1)
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) return  Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
