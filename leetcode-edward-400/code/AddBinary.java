package leetcode;

/**
 * Created by Edward on 28/07/2017.
 */
public class AddBinary {
    /**
     * 67. Add Binary
     * Given two binary strings, return their sum (also a binary string).

     For example,
     a = "11"
     b = "1"
     Return "100".

     time : O(n);
     space : O(n);
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remainder = 0;
        while (i >= 0 || j >= 0) {
            int sum = remainder;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            remainder = sum / 2;
        }
        if (remainder != 0) {
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }
}
