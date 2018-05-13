package leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FractiontoRecurringDecimal
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 166. Fraction to Recurring Decimal
 */
public class FractiontoRecurringDecimal {

    /**
     * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

     If the fractional part is repeating, enclose the repeating part in parentheses.

     For example,

     Given numerator = 1, denominator = 2, return "0.5".
     Given numerator = 2, denominator = 1, return "2".
     Given numerator = 2, denominator = 3, return "0.(6)".

     0.2(34)

     1, 0 + - 越界
     2, 整数
     3, 小数 -> 循环

     time : O(n)
     space : O(n)

     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        res.append(((numerator > 0) ^ (denominator > 0) ? "-" : ""));
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());

        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
