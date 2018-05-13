package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ZigZagConversion
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 6. ZigZag Conversion
 */
public class ZigZagConversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)

     P   A   H   N
     A P L S I I G
     Y   I   R

     And then read line by line: "PAHNAPLSIIGYIR"
     Write the code that will take a string and make this conversion given a number of rows:

     string convert(string text, int nRows);
     convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

     time : O(n);
     space : O(n);

     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        for (int i = 0; i < s.length(); i++) {
            int index = i % (2 * numRows - 2);
            index = index < numRows ? index : 2 * numRows - 2 - index;
            sb[index].append(s.charAt(i));
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
