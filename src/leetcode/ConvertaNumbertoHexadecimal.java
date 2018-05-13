package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ConvertaNumbertoHexadecimal
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 405. Convert a Number to Hexadecimal
 */
public class ConvertaNumbertoHexadecimal {
    /**
     *
     * time : < O(n)
     * space : O(n)

     * @param num
     * @return
     */

    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.append(map[num & 15]);
            num = num >>> 4;
        }
        return res.reverse().toString();
    }
}
